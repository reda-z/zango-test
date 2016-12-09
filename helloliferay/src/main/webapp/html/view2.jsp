<%@page import="zango.example.service.BooksLocalServiceUtil"%>

<%@include file="init.jsp"%>

Ceci est la page suivante
<portlet:actionURL name="deleteBook" var="deleteBookURL" />

<liferay-ui:search-container delta="10" emptyResultsMessage="no-book-were-found">
	<liferay-ui:search-container-results>
	
		<%
		results = BooksLocalServiceUtil.getBookses(searchContainer.getStart(), searchContainer.getEnd());
		total = BooksLocalServiceUtil.getBooksesCount();
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="zango.example.model.Books" keyProperty="bookId" modelVar="book">
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= book.getBookName() %>"
			target="_blank"
		/>

		<liferay-ui:search-container-column-text
			name="book-name"
			property="bookName"
		/>
		<liferay-ui:search-container-column-text
			name="book-author"
			property="bookAuthor"
		/>
		<liferay-ui:search-container-column-text
			name="book-resume"
			property="bookResume"
		/>
		<liferay-ui:search-container-column-text
			name="Configuration"			
		>
			<aui:a href="#" label="Show Details"></aui:a>
			<aui:button name="updateBook" type="edit" value="edit"></aui:button>
			<aui:button name="deleteBook" type="delete" value="delete"></aui:button>	
		</liferay-ui:search-container-column-text>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
