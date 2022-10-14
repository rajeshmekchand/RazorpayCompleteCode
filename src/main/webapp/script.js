
const paymentStart = () => {
	console.log("payment started..");
	
	var amount = $("#payment_field").val();
	console.log(amount);
	if (amount == "" || amount == null) {
		// alert("amount is required !!");
		swal("Failed !!", "amount is required !!", "error");
		return;
	}


	$.ajax({
		url: "/User/ordercreate",
		data: JSON.stringify({ amount: amount, info: "order_request" }),
		contentType: "application/json",
		type: "POST",
		dataType: "json",
		success: function(response) {
			//invoked when success
			console.log(response);
			if (response.status == "created") {
				//open payment form
				let options = {
					key: "rzp_test_haDRsJIQo9vFPJ",
					amount: response.amount,
					currency: "INR",
					name: "NICT INDORE",
					description: "NICT INDORE",
					image: "",
					order_id: response.id,
					handler: function(response) {
						console.log(response.razorpay_payment_id);
						console.log(response.razorpay_order_id);
						console.log(response.razorpay_signature);
						console.log("payment successful !!");
						// alert("congrates !! Payment successful !!");


					/*	updatePaymentOnserver(
							response.razorpay_payment_id,
							response.razorpay_order_id,
							"paid") */
						swal("Good job!", "congrates !! Payment successful !!", "success"); 
					},
					prefill: {
						name: "",
						email: "",
						contact: "",
					},

					notes: {
						address: " NICT INDORE",
					},
					theme: {
						color: "#3399cc",
					},
				};

				let rzp = new Razorpay(options);

				rzp.on("payment.failed", function(response) {
					console.log(response.error.code);
					console.log(response.error.description);
					console.log(response.error.source);
					console.log(response.error.step);
					console.log(response.error.reason);
					console.log(response.error.metadata.order_id);
					console.log(response.error.metadata.payment_id);
					//alert("Oops payment failed !!");
					swal("Failed !!", "Oops payment failed !!", "error");

						});

				rzp.open();
			}
		},
		error: function(error) {
			//invoked when error
			console.log(error);
			alert("something went wrong !!");
		},
	});

};

//update database in payment gateway
function updatePaymentOnServer(payment_id, order_id, status)
{
	$.ajax({
		url: "user/update_order",
		data: JSON.stringify({
			payment_id: payment_id,
			order_id: order_id,
			status: status,
		}),
		contentType: "application/json",
		type: "POST",
		dataType: "json",
		success: function(response) {
          swal("Good job!",  "congrates !! Payment successful !!", "success");
  
	},
    error: function(error){
    	swal("Failed !!", 
      "your payment successful, but we did not get on server ,we will contact you, we will you as soon as possible", "error");
		 
    },   
	});
}; 