/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.lazy;

import cn.hanbell.eap.entity.Qrcode;
import cn.hanbell.eap.entity.Shipment;
import com.lightshell.comm.BaseLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.List;
import java.util.Map;
import org.primefaces.model.SortOrder;

/**
 *
 * @author C2082
 */
public class QrcodeModel extends BaseLazyModel<Qrcode> {

    public QrcodeModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }


    @Override
    public List<Qrcode> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        return super.load(first, pageSize, sortField, sortOrder, filters);
    }
}
