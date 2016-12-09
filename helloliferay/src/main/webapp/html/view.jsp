<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="zango.example.service.ContactLocalServiceUtil"%>
<%@include file="init.jsp"%>

This is the <b>Liferay Book</b>.
 
<liferay-portlet:actionURL name="processName" var="processNameURL">
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="processBook" var="processBookURL">
</liferay-portlet:actionURL>


<liferay-portlet:renderURL var="nextURL">
	<liferay-portlet:param name="mvcPath" value="/html/view2.jsp"/>
</liferay-portlet:renderURL>

<aui:a href="<%=nextURL %>" label="go-next"></aui:a>

<aui:form action="<%=processNameURL %>" name="contactForm">
	<aui:input name="lastName" label="last-name" helpMessage="last-name-help">
	
		<aui:validator name="required"></aui:validator>
	
	</aui:input>
	<aui:input name="firstName" label="first-name" helpMessage="first-name-help"></aui:input>
	<aui:button type="submit" value="submit"></aui:button>
</aui:form>

<aui:form name="sexFormf">
	<aui:input name="sexe" type="radio" value="M" label="male"></aui:input>
	<aui:input name="sexe" type="radio" value="F" label="female"></aui:input>
</aui:form>

<aui:form name="sexFormf">
	<aui:input name="sexe" type="radio" value="M" label="male"></aui:input>
	<aui:input name="sexe" type="radio" value="F" label="female"></aui:input>
</aui:form>

<aui:form action="<%=processBookURL %>" name="bookForm">
	<aui:input name="bookName" label="book-name" helpMessage="book-name-help">
			<aui:validator name="required"></aui:validator>
	</aui:input>	
	<aui:input name="bookAuthor" label="book-author" helpMessage="book-author-help">
			<aui:validator name="required"></aui:validator>
	</aui:input>	
	<aui:input name="bookResume" label="book-resume"></aui:input>
	<aui:button type="submit" value="submit"></aui:button>
</aui:form>


