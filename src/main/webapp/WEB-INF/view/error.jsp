<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<title>Error</title>
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,900"
	rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/error.css" />
</head>
<body>
	<section id="error">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<img src="${pageContext.request.contextPath}/resources/images/alert.svg" width="80px">
					<h2>Oh No!...</h2>
					<p>Please, check the rules on the home page and try again</p>
					<a href="${pageContext.request.contextPath}/search/celebrity">Try
						again!</a>
				</div>
			</div>
		</div>
	</section>
</body>
</html>