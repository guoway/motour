<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="content">
    
    ${res.buysafeno}
    ${res.web}
    ${res.td}
    ${res.MN}
    ${res.webname}
</tiles:putAttribute>
</tiles:insertDefinition>