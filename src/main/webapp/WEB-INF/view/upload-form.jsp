<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,900" rel="stylesheet">    
    <link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/styles.css"/>
	<title>Find the Celebrity</title>
</head>

<body>
	
 <section id="finder">
      <div class="container">
        <div class="row">

          <div class="offset-lg-2 col-lg-8">
            <h1>Find the Celebrity</h1>
          </div>
          <div class="offset-lg-2 col-lg-8">
            <h4>Upload a file with the names of a group of people. The algorithm will find the celebrity </h4>
          </div>
            <div class="offset-lg-2 col-lg-8 ">
              <form method="POST" action="uploadFile" enctype="multipart/form-data">
                <input class="search" type="file" name="file" required> <input type="submit" value="Find the celebrity">
              </form>
            </div>
        </div>     
          <div class="row">       
            <div class="offset-lg-2 col-lg-8 rules">
              <div>
                <img src="${pageContext.request.contextPath}/resources/images/idea.svg" width="50">
              </div>
              <div class="tittle">Supposed</div> 
              <div>- There is always a celebrity in the group of people.</div>
              <div class="tittle">Rules</div>
              <div>- Not allowed empty files<br>
                  - The file extension must be text/plain<br>
                  - You have to enter a name by line in the file<br>
                  - File lines with more than 15 characters or empty will be omitted<br>
              </div>
            </div>
          </div>
        </div>
    </section>
</body>

</html>










