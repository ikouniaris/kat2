<div class="text-center">
	<form class="form-signin">
		<img class="huaPic"
			src="${pageContext.request.contextPath}/images/HUA.jpg"
			alt="Picture of HUA" width="238" height="246">
		<h1 class="h3 mb-3 font-weight-normal">Sign up</h1>
		<label>Please input your credentials below.All three are required!</label>
		<label
			for="inputUsername" class="sr-only">Username</label> <input
			type="username" id="inputUsername" class="form-control"
			placeholder="Username" required>
		<label for="inputEmail" class="sr-only">Email address</label> <input
			type="email" id="inputEmail" class="form-control"
			placeholder="Email address" required autofocus> 
		<label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" id="inputPassword" class="form-control"
			placeholder="Password" required>
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
	
	</form>
</div>