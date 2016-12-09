create table helloService_Books (
	uuid_ VARCHAR(75) null,
	bookId LONG not null primary key,
	bookName VARCHAR(75) null,
	bookAuthor VARCHAR(75) null,
	bookResume VARCHAR(75) null
);

create table helloService_Contact (
	uuid_ VARCHAR(75) null,
	contactId LONG not null primary key,
	lastName VARCHAR(75) null,
	firstName VARCHAR(75) null
);