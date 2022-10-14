<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!--   <script  src="/static/js/jquery-3.1.1.min.js" th:src="@{/js/jquery-3.1.1.min.js}"></script>-->
	
 <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script> 
	

</head>
<body>

	<h3 class="my-3">Enter amount</h3>
	<input id="payment_field" type="text" class="form-control my-2"
		placeholder="Enter amount here" />

	<div class="container text-center mt-3">
		<button onclick="paymentStart()" id=""
			class="btn btn-success btn-block">Pay Now</button>
	</div>



<!--  <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script> -->

<!--  <script src="https://checkout.razorpay.com/v1/checkout.js"></script> -->
<script src="script.js"></script>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>


</body>
</html>