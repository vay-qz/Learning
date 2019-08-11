<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@page import="java.io.OutputStream"%>
<%@page import="com.thunisoft.summer.component.about.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%
    String act = (String) request.getParameter("act");
    AboutContext actx = AboutUtils.getContext();
    if ("report".equals(act)) {
        String sn = request.getServerName();
        int sp = request.getServerPort();
        String cp = request.getContextPath();
        String fileName = "%s_%s_%s_about_report.htm";
        fileName = String.format(fileName, sn, sp, cp);
        String reportName = "attachment;filename=";
        fileName = fileName.replace("\\", "");
        fileName = fileName.replace("/", "");
        reportName = reportName + fileName;
        response.setHeader("Content-Disposition", reportName);
        response.setContentType("text/html;charset=UTF-8");
    }else{
        actx.setReportUrl("about.jsp?act=report");
    }
    InputStream is = AboutUtils.getReportInputStream(actx);
    OutputStream os = response.getOutputStream();
    IOUtils.copy(is, os);
    os.close();
    response.flushBuffer();
    out.clear();
    out = pageContext.pushBody();
%>