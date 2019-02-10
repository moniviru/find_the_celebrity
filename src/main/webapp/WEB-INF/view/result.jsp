<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<title>The Celebrity!</title>
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,900"
	rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/table_styles.css" />
</head>
<body>

	<section id="table">

		<div class="container">

			<div class="row">

				<div class="offset-lg-1 col-lg-10">
					<h2>
						Yay!!!!! The Celebrity is <span class="name_celebrity">
							${celebrity.name} </span> - Id: <span class="name_celebrity"> ${celebrity.indexFile} </span>
					</h2>
					<a href="${pageContext.request.contextPath}/search/celebrity">Try
						again!</a>
				</div>

				<div class="offset-lg-1 col-lg-10">
					<div>${matrix}</div>
				</div>

			</div>

		</div>

	</section>

</body>
</html>