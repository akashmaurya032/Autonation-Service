<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Confirmation Page</title>
<style type="text/css">
#btn-1 {
	height: 50px;
	width: 150px;
	background-color: blue;
	border-radius: 5px;
	border: none;
	color: white;
}

#btn-1:hover {
	border: 2px solid cyan;
}

body {
	display: flex;
	flex-direction: column;
	align-items: center;
}
</style>
</head>
<body>

	<h1>Make payments</h1>
	<button id="btn-1">Pay now</button>
	<h2>Amount : ${amount}</h2>
	<h2 id="success"></h2>
	<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
	<script type="text/javascript">
    document.getElementById("btn-1").onclick = function (){
        fetch("http://localhost:8080/createOrder", { method : "POST", body : JSON.stringify({"amount" : parseFloat("${amount}"), "currency" : "INR", "receipt" : "rcpt_id_4"}),
        headers: {
    "Content-Type": "application/json",
  }})
          .then(response => {
            if(!response.ok)
              throw new Error("Response status: ${response.status}")
            return response.json();
          })
          .then(order => {
            //creating a checkout for this order
            var options = {
              "key": "rzp_test_3Ykoc5fkgZWrW5",
              "amount" : order.amount,
              "currency": order.currency,
              "name": "Autonation USA",
              "description": "Test Transaction",
              "order_id": order.id,
              "handler": function (response1){
                alert("Payment Successful : transcation_id - " + response1.razorpay_payment_id);
                alert(response1.razorpay_order_id);
                alert(response1.razorpay_signature);
                document.getElementById("success").innerText = "Payment Status : Success";
                 },
              "theme": {
                "color": "#3399cc"
                }
            };

            var rzp = new Razorpay(options);
            rzp.on('payment.failed', function (response2){
              alert(response2.error.code);
              alert(response2.error.description);
              alert(response2.error.source);
              alert(response2.error.step);
              alert(response2.error.reason);
              alert(response2.error.metadata.order_id);
              alert(response2.error.metadata.payment_id);
            });
            rzp.open();
          })
          .catch(err => console.log(err));
    };
 
 </script>
</body>
</html>