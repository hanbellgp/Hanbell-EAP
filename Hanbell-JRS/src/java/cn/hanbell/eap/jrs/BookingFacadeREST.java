/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.BookingBean;
import cn.hanbell.eap.ejb.BookingKindBean;
import cn.hanbell.eap.ejb.MeetingRoomBean;
import cn.hanbell.eap.ejb.MeetingScheduleBean;
import cn.hanbell.eap.ejb.SystemProgramBean;
import cn.hanbell.eap.entity.Booking;
import cn.hanbell.eap.entity.BookingKind;
import cn.hanbell.eap.entity.MeetingRoom;
import cn.hanbell.eap.entity.MeetingSchedule;
import cn.hanbell.eap.entity.SystemProgram;
import cn.hanbell.eap.model.BizTalk;
import cn.hanbell.eap.model.GolfGame;
import cn.hanbell.eap.model.TechForum;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.BaseLib;
import com.lightshell.comm.SuperEJB;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author C0160
 */
@Path("eap/booking")
@javax.enterprise.context.RequestScoped
public class BookingFacadeREST extends SuperRESTForEAP<Booking> {

    @Inject
    private BookingKindBean bookingKindBean;
    @Inject
    private BookingBean bookingBean;
    @Inject
    private MeetingRoomBean meetingRoomBean;
    @Inject
    private MeetingScheduleBean meetingScheduleBean;
    @Inject
    private SystemProgramBean systemProgramBean;

    public BookingFacadeREST() {
        super(Booking.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return bookingBean;
    }

    @Override
    public ResponseMessage create(Booking entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        SystemProgram p = systemProgramBean.findBySystemAndAPI("EAP", "booking");
        String formid = bookingBean.getFormId(BaseLib.getDate(), p.getNolead(), p.getNoformat(), p.getNoseqlen());
        entity.setFormid(formid);
        entity.setFormdate(BaseLib.getDate());
        entity.setCreator("EAP-JRS");
        entity.setCredateToNow();
        bookingBean.persist(entity);
        return new ResponseMessage("200", "Code=200");
    }

    @POST
    @Path("create/biztalk")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseMessage createBizTalk(BizTalk entity) {
        boolean flag;
        MeetingRoom r;
        String code, msg;
        SystemProgram p = systemProgramBean.findBySystemAndAPI("EAP", "booking");
        String formid = bookingBean.getFormId(BaseLib.getDate(), p.getNolead(), p.getNoformat(), p.getNoseqlen());
        BookingKind bk = bookingKindBean.findByKind(entity.getFormid());
        if (bk == null) {
            return new ResponseMessage("404", "预约内容不存在");
        }
        List<MeetingRoom> roomList = meetingRoomBean.findByKind(entity.getFormid());
        if (roomList == null || roomList.isEmpty()) {
            return new ResponseMessage("404", "预约会议室不存在");
        }
        try {
            Date talkDate = BaseLib.getDate("yyyy-MM-dd", entity.getStartDate());

            Calendar st = Calendar.getInstance();
            st.setTime(BaseLib.getDate("HH:mm", entity.getStartTime()));//开始时间

            Calendar et = Calendar.getInstance();
            et.setTime(BaseLib.getDate("HH:mm", entity.getStartTime()));
            et.add(Calendar.MINUTE, entity.getMinutes() + 3);//结束时间，预留出3分钟整理时间

            r = null;
            List<MeetingSchedule> scheduleList = meetingScheduleBean.findByKindAndTime(entity.getFormid(), talkDate, st.getTime(), talkDate, et.getTime());
            if (scheduleList == null || scheduleList.isEmpty()) {
                r = roomList.get(0);
            } else if (scheduleList.size() >= roomList.size()) {
                return new ResponseMessage("401", "此时间段已约满");
            } else {
                for (MeetingRoom room : roomList) {
                    flag = true;
                    for (MeetingSchedule schedule : scheduleList) {
                        if (room.getId() == schedule.getPid()) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        r = room;
                        break;
                    }
                }
            }
            if (r == null) {
                return new ResponseMessage("401", "此时间段已约满");
            }
            MeetingSchedule s = new MeetingSchedule();
            s.setPid(r.getId());
            s.setSeq(1);
            s.setBookingid(formid);
            s.setSubject(entity.getCompany());
            s.setContent(entity.getRemark());
            s.setStartDate(talkDate);
            s.setStartTime(st.getTime());
            s.setEndDate(talkDate);
            s.setEndTime(et.getTime());
            s.setMinutes(entity.getMinutes());

            et.add(Calendar.MINUTE, -3);
            Booking b = new Booking();
            b.setBookingKind(bk);
            b.setFormid(formid);
            b.setFormdate(BaseLib.getDate());
            b.setCreator("EAP-JRS");
            b.setCredateToNow();
            b.setName(entity.getName());
            b.setGender(entity.getGender());
            b.setMobile(entity.getMobile());
            b.setEmail(entity.getEmail());
            b.setCompany(entity.getCompany());
            b.setTitle(entity.getTitle());
            b.setStartDate(talkDate);
            b.setStartTime(BaseLib.getDate("HH:mm", entity.getStartTime()));
            b.setEndDate(talkDate);
            b.setEndTime(BaseLib.getDate("HH:mm", BaseLib.formatDate("HH:mm", et.getTime())));
            b.setContacter(entity.getContacter());
            b.setRemark(entity.getRemark());
            b.setRoom(r.getName());
            b.setMsgNotify(bk.getMsgNotify());
            b.setMsgNotified(bk.getMsgNotified());
            meetingScheduleBean.persist(s);
            bookingBean.persist(b);
            code = "200";
            msg = formid;
        } catch (Exception ex) {
            code = "500";
            msg = ex.getMessage();
        }
        return new ResponseMessage(code, msg);
    }

    @POST
    @Path("create/golf")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseMessage createGolfGame(GolfGame entity) {
        String code, msg;
        SystemProgram p = systemProgramBean.findBySystemAndAPI("EAP", "booking");
        String formid = bookingBean.getFormId(BaseLib.getDate(), p.getNolead(), p.getNoformat(), p.getNoseqlen());
        BookingKind bk = bookingKindBean.findByKind(entity.getFormid());
        if (bk == null) {
            return new ResponseMessage("404", "预约内容不存在");
        }
        Booking b = new Booking();
        b.setBookingKind(bk);
        b.setFormid(formid);
        b.setFormdate(BaseLib.getDate());
        b.setStartDate(bk.getStartDate());
        b.setStartTime(bk.getStartTime());
        b.setEndDate(bk.getEndDate());
        b.setEndTime(bk.getEndTime());
        b.setMsgNotify(bk.getMsgNotify());
        b.setMsgNotified(bk.getMsgNotified());
        b.setCreator("EAP-JRS");
        b.setCredateToNow();
        b.setName(entity.getName());
        b.setGender(entity.getGender());
        b.setMobile(entity.getMobile());
        b.setEmail(entity.getEmail());
        b.setCompany(entity.getCompany());
        b.setTitle(entity.getTitle());
        b.setKey1(bk.getKey1());
        b.setValue1(String.valueOf(entity.getValue1()));
        b.setKey2(bk.getKey2());//是否用晚餐
        if (entity.getValue2()) {
            b.setValue2("是");
        } else {
            b.setValue2("否");
        }
        b.setKey3(bk.getKey3());//是否租球具
        if (entity.getValue3()) {
            b.setValue3("是");
        } else {
            b.setValue3("否");
        }
        b.setKey4(bk.getKey4());//衣服尺码
        b.setValue4(entity.getValue4());
        b.setKey5(bk.getKey5());//乘坐巴士
        if (entity.getValue5()) {
            b.setValue5("是");
        } else {
            b.setValue5("否");
        }
        b.setKey6(bk.getKey6());//自行驾车
        if (entity.getValue6()) {
            b.setValue6("是");
        } else {
            b.setValue6("否");
        }
        b.setKey7(bk.getKey7());
        b.setValue7(entity.getValue7());
        b.setKey8(bk.getKey8());
        b.setValue8(entity.getValue8());
        b.setRemark(entity.getRemark());
        try {
            bookingBean.persist(b);
            code = "200";
            msg = formid;
        } catch (Exception ex) {
            code = "500";
            msg = ex.getMessage();
        }
        return new ResponseMessage(code, msg);
    }

    @POST
    @Path("create/forum")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseMessage createTechForum(TechForum entity) {
        String code, msg;
        SystemProgram p = systemProgramBean.findBySystemAndAPI("EAP", "booking");
        String formid = bookingBean.getFormId(BaseLib.getDate(), p.getNolead(), p.getNoformat(), p.getNoseqlen());
        BookingKind bk = bookingKindBean.findByKind(entity.getFormid());
        if (bk == null) {
            return new ResponseMessage("404", "预约内容不存在");
        }
        Booking b = new Booking();
        b.setBookingKind(bk);
        b.setFormid(formid);
        b.setFormdate(BaseLib.getDate());
        b.setStartDate(bk.getStartDate());
        b.setStartTime(bk.getStartTime());
        b.setEndDate(bk.getEndDate());
        b.setEndTime(bk.getEndTime());
        b.setMsgNotify(bk.getMsgNotify());
        b.setMsgNotified(bk.getMsgNotified());
        b.setCreator("EAP-JRS");
        b.setCredateToNow();
        b.setName(entity.getName());
        b.setGender(entity.getGender());
        b.setMobile(entity.getMobile());
        b.setEmail(entity.getEmail());
        b.setCompany(entity.getCompany());
        b.setTitle(entity.getTitle());
        b.setKey1(bk.getKey1());
        b.setValue1(entity.getValue1());
        b.setRemark(entity.getRemark());
        try {
            bookingBean.persist(b);
            code = "200";
            msg = formid;
        } catch (Exception ex) {
            code = "500";
            msg = ex.getMessage();
        }
        return new ResponseMessage(code, msg);
    }

    @GET
    @Path("list/schedule/idle/{bookingkind}/{date}/{minutes}")
    @Produces({"application/json"})
    public List<ResponseMessage> findIdleTime(@PathParam("bookingkind") String kind, @PathParam("date") String date, @PathParam("minutes") int minutes) {
        List<ResponseMessage> repList = new ArrayList<>();
        List<MeetingSchedule> idleList = null;
        try {
            idleList = meetingRoomBean.findIdleTime(kind, BaseLib.getDate("yyyy-MM-dd", date), minutes);
        } catch (ParseException ex) {
            Logger.getLogger(BookingFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (idleList == null || idleList.isEmpty()) {
            repList.add(new ResponseMessage("401", date + "已全部约满"));
        } else {
            for (MeetingSchedule ms : idleList) {
                repList.add(new ResponseMessage("200", BaseLib.formatDate("HH:mm", ms.getStartTime()) + "-" + BaseLib.formatDate("HH:mm", ms.getEndTime()) + "可以预约"));
            }
        }
        return repList;
    }

}
