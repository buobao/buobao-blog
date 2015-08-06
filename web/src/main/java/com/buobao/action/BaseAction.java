package com.buobao.action;

import com.buobao.bean.Pager;
import com.buobao.bean.Result;
import com.buobao.utils.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dqf on 2015/7/15.
 */
@Scope("prototype")
public class BaseAction extends ActionSupport {
    private static final long serialVersionUID = 6718838822334455667L;
    protected static final int mpManager = 0; //0->cookie 1->session

    protected final static int LISTVIEW_WEB_SIZE = 30;
    protected final static int LISTVIEW_MP_SIZE = 10;

    protected final static int LISTVIEW_DATATYPE_CLINET = 0x01;
    protected final static int LISTVIEW_DATATYPE_LINKMAN = 0x02;
    protected final static int LISTVIEW_DATATYPE_NEGOTIATION = 0x03;
    protected final static int LISTVIEW_DATATYPE_BUSINESS = 0x04;
    protected final static int LISTVIEW_DATATYPE_CONTENT = 0x05;
    protected final static int LISTVIEW_DATATYPE_USER= 0x06;
    protected final static int LISTVIEW_DATATYPE_PRODUCT= 0x07;
    protected final static int LISTVIEW_DATATYPE_RESERVATION= 0x08;
    protected final static int LISTVIEW_DATATYPE_PERFORMANCE= 0x09;
    protected final static int LISTVIEW_DATATYPE_CATEGORY_PRODUCT = 0x10;

    protected final static int LISTVIEW_DATATYPE_CLINET_LINKMAN = 0x11;
    protected final static int LISTVIEW_DATATYPE_CLINET_NEGOTIATION = 0x12;
    protected final static int LISTVIEW_DATATYPE_NEGOTIATION_BUSINESS = 0x13;
    protected final static int LISTVIEW_DATATYPE_BUSINESS_PRODUCT = 0x14;
    protected final static int LISTVIEW_DATATYPE_BUSINESS_CONTRACT = 0x15;
    protected final static int LISTVIEW_DATATYPE_NEGOTIATION_LINKMAN = 0x16;
    protected final static int LISTVIEW_DATATYPE_NEGOTIATION_USER = 0x17;
    protected final static int LISTVIEW_DATATYPE_CLINET_RESERVATION= 0x18;
    protected final static int LISTVIEW_DATATYPE_CONTRACT_PERFORMANCE= 0x19;
    protected final static int LISTVIEW_DATATYPE_BUSINESS_NEGOTIATION = 0x20;
    protected final static int LISTVIEW_DATATYPE_CLINET_BUSINESS = 0x21;
    protected final static int LISTVIEW_DATATYPE_USER_BOSS = 0x22;

    protected final static int LISTVIEW_DATATYPE_RESERVATION_BYTIME= 0x31;
    protected final static int LISTVIEW_DATATYPE_NEGOTIATION_BYTIME = 0x32;

    protected final static int LISTVIEW_DATATYPE_PUSHLOG_MESSAGE = 0x61;

    protected final static int LISTVIEW_DATATYPE_COMMENT_TARGET = 0x71;
    protected final static int LISTVIEW_DATATYPE_COMMENT_ABOUTME = 0x72;
    protected final static int LISTVIEW_DATATYPE_COMMENT_USER = 0x73;

    public static final String VIEW = "view";
    public static final String LIST = "list";
    public static final String STATUS = "status";
    public static final String WARN = "warn";
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String MESSAGE = "message";
    public static final String CONTENT = "content";
    public static final String IMPORT = "import";
    public static final String INPUT = "input";

    protected String result;
    protected String id;
    protected String keyId;
    protected String tempId;
    protected String timestamp;
    protected String keyIds;
    protected String keyNames;
    protected String[] ids;
    protected Pager pager;
    protected String logInfo;// 日志记录信息
    protected String redirectionUrl;// 操作提示后的跳转URL,为null则返回前一页

    /*常用对象*/
    protected String view;//视图名
    protected String cat;//关键字
    protected int page;//页数
    protected int rows;//Size
    protected long total = 0;
    protected String stringData;//Size
    protected String filters;
    protected String order;//desc asc
    protected String sort;//desc asc

    /*jqGrid*/
    protected String sidx;
    protected String _search;
    protected String nd;
    protected String sord;

    protected int pageIndex;
    protected int pageSize;
    protected String pageProperty;
    protected String pageKeyword;

    protected int catalog;

    //当前项目ID
    protected String current_ProjectId;

    //提交还是保存的状态 空或者null 则为save submit 判断不等于submit
    protected String saveoption;

    /* Edit 对象*/
    protected String oper;
    protected String parent;//父ID	// 最后登录异常Session名称
    /* 通用树节点名 对象*/
    protected String nodeName;

    protected static final String EDIT = "edit";
    protected static final String ADD = "add";
    protected static final String DEL = "del";

    //上传功能
    private String root;
    private String lastName;
    protected static final String fileDirName = "SmartSales";
    protected SimpleDateFormat sdf;
    protected Calendar calendar;

    //校验
    protected String newValue;
    protected String oldValue;
    protected String entityName;
    protected String validatePro;

    //微信通用参数
    protected String code;
    protected String state;

    protected String _;//实时刷新


    public String formatTime(Date time){
        return DateUtil.friendly_time(time);
    }
    //格式化数字显示
    public String formatMoney(BigDecimal m){
        if(m==null){
            return "0.000,000";
        }else if(m.doubleValue() == 0){
            return "0.000,000";
        }else{
            return String.format("%,.6f",m);
        }
    }
    //获取省略掉的内容，最长12个字符
    public String getShort(String content){
        return content.length() >12?(content.substring(0,9)+"..."):content;
    }
    public boolean isSubmit(String saveoption){
        return (!StringUtils.isEmpty(saveoption))&&(StringUtils.equals("submit", saveoption));
    }

    /**
     * Cookieの追加
     * @return
     * @throws Exception
     */
    public void addCookie(String name,String value){
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60*60*24*365);
        ServletActionContext.getResponse().addCookie(cookie);
    }

    /**
     * Cookieの、删除
     * @return
     * @throws Exception
     */
    public void deleteCookie(String name){
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies)
            {
                //System.out.println("cookie.getName():"+cookie.getName() + " name:" + name);
                if(cookie.getName().equals(name))
                {
                    cookie.setMaxAge(0);
                    cookie.setValue("");
                    cookie.setPath("/");
                    ServletActionContext.getResponse().addCookie(cookie);
                    //return cookie.getValue();
                }
            }
        }
    }

    /**
     * Cookieの取得
     * @return
     * @throws Exception
     */
    public String getCookie(String name){
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies)
            {
                if(cookie.getName().equals(name))
                {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /*
         * state = 200 成功，300必须提示，有警告信息存在，400失败
         * */
    public String ajaxCallback(String state,String message){
        String json = "{\"state\":\""+state+"\",\"message\":\""+message+"\"}";
        return ajaxJson(json);
    }
    public String ajaxCallback(String state,String message,String title){
        String json = "{\"state\":\""+state+"\",\"message\":\""+message+"\",\"title\":\""+title+"\"}";
        return ajaxJson(json);
    }
    public String ajaxHtmlCallback(String state,String message){
        String json = "{\"state\":\""+state+"\",\"message\":\""+message+"\"}";
        return ajaxHtml(json);
    }
    public String ajaxHtmlCallback(String state,String message,String title){
        String json = "{\"state\":\""+state+"\",\"message\":\""+message+"\",\"title\":\""+title+"\"}";
        return ajaxHtml(json);
    }

    /**
     * 返回App Json数据/结果
     * @param errorCode 成功 = 1
     * @param errorMessage 错误消息
     * @param object  JsonObject数据
     * @return
     */
    public String ajaxHtmlAppResult(int errorCode, String errorMessage, JSONObject object ){
        //{"result":{"errorCode":"","errorMessage":""},"data":""}
        Map<String, Object> mpMap = new HashMap<String, Object>();

        Map<String, Object> rsMap = new HashMap<String, Object>();
        rsMap.put("errorCode", errorCode);
        rsMap.put("errorMessage", errorMessage);

        mpMap.put("result", JSONObject.fromObject(rsMap));
        mpMap.put("data", object==null?"":object);

        return ajaxJson(JSONObject.fromObject(mpMap).toString());
    }

    public String ajaxHtmlAppResult(Result result){
        return ajaxHtmlAppResult(result.getState(), StringUtils.isNotEmpty(result.getMessage())?result.getMessage():"", result.getData()!=null?JSONObject.fromObject(result.getData()):null);
    }
    // 获取Attribute
    public Object getAttribute(String name) {
        return ServletActionContext.getRequest().getAttribute(name);
    }

    // 设置Attribute
    public void setAttribute(String name, Object value) {
        ServletActionContext.getRequest().setAttribute(name, value);
    }

    // 获取Parameter
    public String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    // 获取Parameter数组
    public String[] getParameterValues(String name) {
        return getRequest().getParameterValues(name);
    }

    // 获取Session
    public Object getSession(String name) {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        return session.get(name);
    }

    // 获取Session
    public Map<String, Object> getSession() {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        return session;
    }

    // 设置Session
    public void setSession(String name, Object value) {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        session.put(name, value);
    }

    // 获取Request
    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    // 获取Response
    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    // 获取Application
    public ServletContext getApplication() {
        return ServletActionContext.getServletContext();
    }

    // AJAX输出，返回null
    public String ajax(String content, String type) {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType(type + ";charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String ajaxResult(Result result){
        return ajaxHtmlAppResult(result.getState(), StringUtils.isNotEmpty(result.getMessage())?result.getMessage():"", result.getData()!=null?JSONObject.fromObject(result.getData()):null);
    }

    // AJAX输出文本，返回null
    public String ajaxText(String text) {
        return ajax(text, "text/plain");
    }

    // AJAX输出HTML，返回null
    public String ajaxHtml(String html) {
        return ajax(html, "text/html");
    }

    // AJAX输出XML，返回null
    public String ajaxXml(String xml) {
        return ajax(xml, "text/xml");
    }

    // 根据字符串输出JSON，返回null
    public String ajaxJson(String jsonString) {
        return ajax(jsonString, "application/json");
    }

    // 根据Map输出JSON，返回null
    public String ajaxJson(Map<String, String> jsonMap) {
        JSONObject jsonObject = JSONObject.fromObject(jsonMap);
        return ajax(jsonObject.toString(), "application/json");
    }

    // 输出JSON警告消息，返回null
    public String ajaxJsonWarnMessage(String message) {
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put(STATUS, WARN);
        jsonMap.put(MESSAGE, message);
        JSONObject jsonObject = JSONObject.fromObject(jsonMap);
        return ajax(jsonObject.toString(), "text/json");
    }

    // 输出JSON成功消息，返回null
    public String ajaxJsonSuccessMessage(String message) {
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put(STATUS, SUCCESS);
        jsonMap.put(MESSAGE, message);
        JSONObject jsonObject = JSONObject.fromObject(jsonMap);
        return ajax(jsonObject.toString(), "text/html");
    }

    // 输出JSON错误消息，返回null
    public String ajaxJsonErrorMessage(String message) {
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put(STATUS, ERROR);
        jsonMap.put(MESSAGE, message);
        JSONObject jsonObject = JSONObject.fromObject(jsonMap);
        return ajax(jsonObject.toString(), "text/html");
    }

    protected static OutputStream getTheOutputStream(){
        try {
            return getTheResponse().getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    protected static HttpServletResponse getTheResponse(){
        return ServletActionContext.getResponse();
    }

    protected String getContentType(String fileName) {
        String fileNameTmp = fileName.toLowerCase();
        String ret = "";
        if (fileNameTmp.endsWith("txt")) {
            ret = "text/plain";
        }else if (fileNameTmp.endsWith("gif")) {
            ret = "image/gif";
        }else if (fileNameTmp.endsWith("jpg")) {
            ret = "image/jpeg";
        }else if (fileNameTmp.endsWith("jpeg")) {
            ret = "image/jpeg";
        }else if (fileNameTmp.endsWith("jpe")) {
            ret = "image/jpeg";
        }else if (fileNameTmp.endsWith("zip")) {
            ret = "application/zip";
        }else if (fileNameTmp.endsWith("rar")) {
            ret = "application/rar";
        }else if (fileNameTmp.endsWith("doc")) {
            ret = "application/msword";
        }else if (fileNameTmp.endsWith("ppt")) {
            ret = "application/vnd.ms-powerpoint";
        }else if (fileNameTmp.endsWith("xls")) {
            ret = "application/vnd.ms-excel";
        }else if (fileNameTmp.endsWith("html")) {
            ret = "text/html";
        }else if (fileNameTmp.endsWith("htm")) {
            ret = "text/html";
        }else if (fileNameTmp.endsWith("tif")) {
            ret = "image/tiff";
        }else if (fileNameTmp.endsWith("tiff")) {
            ret = "image/tiff";
        }else if (fileNameTmp.endsWith("pdf")) {
            ret = "application/pdf";
        }else if (fileNameTmp.endsWith("rtf")) {
            ret = "application/rtf";
        }else if (fileNameTmp.endsWith("asf")) {
            ret = "video/x-ms-asf";
        }else if (fileNameTmp.endsWith("avi")) {
            ret = "video/avi";
        }else if (fileNameTmp.endsWith("wav")) {
            ret = "audio/wav";
        }else if (fileNameTmp.endsWith("mp3")) {
            ret = "audio/mpeg3";
        }else{
            ret = "APPLICATION/OCTET-STREAM";
        }
        return ret;
    }

    // 设置页面不缓存
    public void setResponseNoCache() {
        getResponse().setHeader("progma", "no-cache");
        getResponse().setHeader("Cache-Control", "no-cache");
        getResponse().setHeader("Cache-Control", "no-store");
        getResponse().setDateHeader("Expires", 0);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    public String getRedirectionUrl() {
        return redirectionUrl;
    }

    public void setRedirectionUrl(String redirectionUrl) {
        this.redirectionUrl = redirectionUrl;
    }
    public String getView() {
        return view;
    }
    public void setView(String view) {
        this.view = view;
    }
    public String getCat() {
        return cat;
    }
    public void setCat(String cat) {
        this.cat = cat;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public String getStringData() {
        return stringData;
    }
    public void setStringData(String stringData) {
        this.stringData = stringData;
    }
    public String getOper() {
        return oper;
    }
    public void setOper(String oper) {
        this.oper = oper;
    }
    public String getParent() {
        return parent;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
    public String getKeyId() {
        return keyId;
    }
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
    public String getCurrent_ProjectId() {
        return current_ProjectId;
    }
    public void setCurrent_ProjectId(String current_ProjectId) {
        this.current_ProjectId = current_ProjectId;
    }
    public String getSaveoption() {
        return saveoption;
    }
    public void setSaveoption(String saveoption) {
        this.saveoption = saveoption;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getKeyIds() {
        return keyIds;
    }

    public void setKeyIds(String keyIds) {
        this.keyIds = keyIds;
    }

    public String getKeyNames() {
        return keyNames;
    }

    public void setKeyNames(String keyNames) {
        this.keyNames = keyNames;
    }

    public String get_() {
        return _;
    }

    public void set_(String _) {
        this._ = _;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public String getPageProperty() {
        return pageProperty;
    }

    public void setPageProperty(String pageProperty) {
        this.pageProperty = pageProperty;
    }

    public String getPageKeyword() {
        return pageKeyword;
    }

    public void setPageKeyword(String pageKeyword) {
        this.pageKeyword = pageKeyword;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String get_search() {
        return _search;
    }

    public void set_search(String _search) {
        this._search = _search;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getValidatePro() {
        return validatePro;
    }

    public void setValidatePro(String validatePro) {
        this.validatePro = validatePro;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }





}
