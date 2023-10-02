<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="newz"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"
	href="https://github.com/mnk17arts/plan2k22/blob/main/favicon.png?raw=true">
<title>NEWZ - A spring-mvc app</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<style>
.table-dark {
	background-color: #212529;
	color: white;
}
</style>
</head>
<body style="background-color: #293929">

	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid py-4">
			<span class="navbar-brand mb-0 mx-auto" style="font-size: 2.2rem">NEWZ
				Application Assignment</span> <a href="#news"
				class="btn btn-outline-success">News Articles</a>
		</div>
	</nav>

	<div class="container mt-4 bg-dark text-light p-4 rounded"
		style="max-width: 600px;">
		<form action="add" method="post">
			<div class="mb-3">
				<label for="newsId" class="form-label">News ID</label> <input
					type="text" class="form-control" id="newsId" name="newsId"
					placeholder="Enter News ID" required>
			</div>
			<div class="mb-3">
				<label for="newsTitle" class="form-label">News Title</label> <input
					type="text" class="form-control" id="newsTitle" name="newsTitle"
					placeholder="Enter News Title" required>
			</div>
			<div class="mb-3">
				<label for="author" class="form-label">Author</label> <input
					type="text" class="form-control" id="author" name="author"
					placeholder="Enter Author Name" required>
			</div>
			<div class="mb-3">
				<label for="description" class="form-label">Description</label> <input
					type="text" class="form-control" id="description"
					name="description" placeholder="Enter Description" required>
			</div>
			<div class="mb-3">
				<label for="newsContent" class="form-label">News Content</label>
				<textarea class="form-control" id="newsContent" name="newsContent"
					rows="5" placeholder="Enter News Content" required></textarea>
			</div>
			<button type="submit" class="btn btn-success">Submit</button>
		</form>
	</div>
	<div id="news"
		class="container-fluid mt-4 bg-dark text-light p-4 rounded">
		<table class="table table-dark">
			<thead>
				<tr>
					<th>NewsID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Description</th>
					<th>PublishedAt</th>
					<th>Content</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<newz:forEach var="newsItem" items="${newsList}">
					<tr>
						<td>${newsItem.newsId }</td>
						<td>${newsItem.newsTitle}</td>
						<td>${newsItem.author }</td>
						<td>${newsItem.description }</td>
						<td>${newsItem.dateTimeStamp }</td>
						<td>${newsItem.content}</td>
						<td>
							<form action="delete" method="post"
								onsubmit="return confirm('Are you sure you want to delete this news item?');">
								<input type="hidden" name="newsId" value="${newsItem.newsId}">
								<button type="submit" class="btn btn-outline-danger">Delete</button>
							</form>
						</td>
					</tr>
				</newz:forEach>
			</tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>
