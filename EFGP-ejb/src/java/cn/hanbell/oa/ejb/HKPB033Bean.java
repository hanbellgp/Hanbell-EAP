/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKPB033;
import cn.hanbell.oa.entity.NoCmDocument;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.xerces.impl.xpath.regex.Match;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class HKPB033Bean extends SuperEJBForEFGP<HKPB033> {

    @EJB
    NoCmDocumentBean noCmDocumentBean;
    @EJB
    protected cn.hanbell.oa.ejb.WorkFlowBean workFlowBean;

    public HKPB033Bean() {
        super(HKPB033.class);
    }

    public String copyDocumentToOaHttpFiles(String psn) throws Exception {
        HKPB033 entity = findByPSN(psn);
        JSONObject jsonEntity = XML.toJSONObject(entity.getFormInstance().getFieldValues());
        StringBuffer oids = new StringBuffer("");
        //数组存在多个附件
        if (jsonEntity.toString().contains("[") || jsonEntity.toString().contains("]")) {
            JSONArray jsonList = jsonEntity.getJSONObject("HK_PB033").getJSONObject("Attachment").getJSONObject("attachments").getJSONArray("attachment");
            for (Object o : jsonList) {
                JSONObject obj = (JSONObject) o;
                oids.append("'").append(obj.getString("OID")).append("',");
            }
        } else {
            JSONObject obj = jsonEntity.getJSONObject("HK_PB033").getJSONObject("Attachment").getJSONObject("attachments").getJSONObject("attachment");
            oids.append("'").append(obj.getString("OID")).append("',");
        }
//        noCmDocumentBean.findByOid("231241241");
        List<NoCmDocument> list = noCmDocumentBean.findByInOid(oids.substring(0, oids.length() - 1));
        for (NoCmDocument d : list) {
            d.getPhysicalName();
            //切割后剩余两位则移除
            String name = d.getPhysicalName().substring(2);
            if (name.length() % 2 == 2) {
                name = name.substring(0, name.length() - 3);
            } else {
                name = name.substring(0, name.length() - 2);
            }
            String rStr = name.replaceAll("(\\w{2})(?=.)", "$1,");

            String[] strArr = rStr.split(",");

            StringBuffer url = new StringBuffer(workFlowBean.HOST_ADD);
            url.append("/attachment");
            for (int i = strArr.length - 1; i >= 0; i--) {
                url.append("/").append(strArr[i]);
            }
            url.append("/").append(d.getPhysicalName()).append(".").append(d.getExtentionName());
            System.out.println(url.toString());
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", workFlowBean.OA_USERNO, workFlowBean.OA_PASSWORD);
            SmbFile smbFile = new SmbFile(url.toString(), auth);
            SmbFileInputStream smbfos = new SmbFileInputStream(smbFile);
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] bytes = null;
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = smbfos.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            bytes = swapStream.toByteArray();
            Encoder encoder = Base64.getEncoder();
            String args = encoder.encodeToString(bytes);
            url.setLength(0);
            url.append(workFlowBean.HOST_ADD);
            url.append("/Files/").append(d.getPhysicalName()).append(".").append(d.getExtentionName());
            workFlowBean.getShareFileContent(workFlowBean.OA_USERNO, workFlowBean.OA_PASSWORD, url.toString(), args);
        }
        return "23123";
    }
}
