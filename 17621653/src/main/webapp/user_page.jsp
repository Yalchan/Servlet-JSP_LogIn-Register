<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="bean.User"%>
<%@page import="model.UserSkill"%>
<%@page import="java.util.List"%>
<%@page import="enums.TypeSkill"%>
<%@page import="model.Address"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style/user_page.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user" class="bean.User"  scope="request" />
<header class="header"></header>
	
	<main class="main">
		<div class="shell">
			<div class="profile">
				<img class="profile-image" src="images/user.jpg" />

				<div class="profile-info">
					<h2 class="heading">User information</h2>
					<span class="text">Name: 
					 <jsp:getProperty name="user" property="firstName"/> 
					<jsp:getProperty name="user" property="secondName"/>
					<jsp:getProperty name="user" property="familyName"/>
					  </span>
					<span class="text">Job: 
					<jsp:getProperty name="user" property="jobName"/> 
					</span>
					<span class="text profile-text">Description: 
					<jsp:getProperty name="user" property="description"/> 
					</span>
				</div>
			</div>
			
			<h1 class="heading centered">Skills</h1>
			<div class="info-box">
				<div class="pro-skills">
					<h2 class="heading centered">Professional</h2>
						<span class="text"></span>
					 	<div class="bar bar-java"></div>
					 	
					 	<%List<UserSkill> skills =(List<UserSkill>) user.getSkills(); 
					for(int i = 0; i<skills.size();i++){
						if(skills.get(i).getSkillType().equals(TypeSkill.PROFESSIONAL)){%>
						<span class="text"><%=skills.get(i).getSkillName() %></span>
					 	<div class="bar bar-java"></div>
					
					<% }
					}
					%>
					
					 	
				</div>
				<div class="pers-skills">
					<h2 class="heading centered">Social</h2>
				<% for(int i = 0; i<skills.size();i++){
						if(skills.get(i).getSkillType().equals(TypeSkill.SOCIAL)){%>
							<span class="text"><%=skills.get(i).getSkillName() %></span>
					 		<div class="bar bar-java"></div>
					 		
					<% }
					}
					%>
				</div>
			</div>

			<h1 class="heading centered contact-heading">Contacts </h1>
			<div class="info-box">
				<div class="contact-box">
					<span class="text">E-mail: 
					<jsp:getProperty name="user" property="email"/> 
					</span>
				
					<a href="localhost" class="contact-text"> </a>
				</div>

				<div class="contact-box">
				
				<%Address a = user.getAddress();%>
				
					<span class="text">City: 
					<jsp:getProperty name="user" property="city"/>
					<span class="contact-text"></span>
				</div>

				<div class="contact-box">
					<span class="text">Phone number:
					<jsp:getProperty name="user" property="phoneNumber"/> 
					</span>
					<span class="contact-text"></span>
				</div>

				<div class="contact-box">	
					<span class="text">Street:
				<jsp:getProperty name="user" property="street"/>
					 </span>
					<span class="contact-text">
					</span>
				</div>
			</div>
		</div>
	</main>
	
	<footer class="footer"></footer>
</body>
</html>