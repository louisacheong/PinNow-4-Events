<%@ include file='WEB-INF/jspf/header.jspf' %>
  
<div class="top-content">
    <div class="inner-bg">   	
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text"><h2><strong>PinNow 4 Events</h2>
                    <h2>Editing User Settings</h2></div>
            </div>
     <div class="row">       
         <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <div class="form-box">
                    
	            <div class="form-bottom">
                        <form method="POST" action="./RegistrationServlet" accept-charset="UTF-8" role="form" id="registration-form" class="registration-form">

				                    	<div class="form-group">
				                        	<label class="sr-only" for="form-email">Email*</label>
				                        	<input type="text" name="form-email" placeholder="Email..." class="form-email form-control" id="form-email">
				                        </div>
                                                        <div class="form-group">
				                        	<label class="sr-only" for="form-username">Username*</label>
				                        	<input type="text" name="form-username" placeholder="Username" class="form-username form-control" id="form-username">
				                        </div>
                                                        <div class="form-group">
				                    		<label class="sr-only" for="form-first-name">First name*</label>
				                        	<input type="text" name="form-first-name" placeholder="First name..." class="form-first-name form-control" id="form-first-name">
				                        </div>
                                                        <div class="form-group">
				                    		<label class="sr-only" for="form-last-name">Last name*</label>
				                        	<input type="text" name="form-last-name" placeholder="Last name..." class="form-last-name form-control" id="form-last-name">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-country">Country</label>
				                        	<input type="text" name="form-country" placeholder="Country" class="form-country form-control" id="form-country">
				                        </div>
				                        
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-gender">Gender*</label>
				                        	<textarea name="form-gender" placeholder="Gender" 
				                        				class="form-gender form-control" id="form-gender"></textarea>
				                        </div>
				                        <input class="btn btn-success btn-block" type="Submit" value="Sign me up!">
				                    </form>
			                    </div>
                        	</div>
                        	
                        </div>
                    <div class="col-sm-4"></div>
                    </div>
                </div>
        </div>
        </div>

<!--%@ include file='WEB-INF/jspf/footer.jspf' %-->