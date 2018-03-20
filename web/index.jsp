
<%@ include file='WEB-INF/view/header.jspf' %>
<c:set var="title" value="Login" scope="request"/>
<c:set var="page" value="login" scope="request"/>

<div class="top-content">
    <div class="inner-bg">   	
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text"><h2><strong>PinNow 4 Events</h2>
                    <h2>Login &amp; Registration Form</h2></div>
            </div>
            <div class="row">
                <c:if test="${successEdit != null}">
                    <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 500px; margin: 0px auto;">
                    ${successEdit}
                    </div>
                </c:if>
                <div class="col-sm-5">
                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Log in now</h3>
                                <p>Enter username and password to log in:</p>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-key"></i>
                            </div>
                        </div>
                        <div class="form-bottom">
                            <!-- WEBSITE Login-->
                            <form method="POST" action="./welcome" accept-charset="UTF-8" role="form" id="loginform" class="form-signin">
                                <div class="form-group">
                                    <br>
                                    <br>
                                    <label class="sr-only" for="form-email">Email</label>
                                        <input type="text" name="email" placeholder="Email..." class="form-control" id="form-email">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-password">Password</label>
                                        <input type="password" name="password" placeholder="Password..." class="form-control" id="form-password">
                                </div>
                                <p style="margin-top:45px"><input class="btn btn-success btn-block" type="submit" value="Login"></p>
                                
                                <center><p style="font-size: smaller; margin-top: 20px"> Try with email/password combination: admin@pin.net/adminadmin </p></center>
                            </form> 
                        
       
        
    <!-- Google sign in -->
    <center><p style="margin-top:30px;">or</p></center>
    <center><div id="googleLogin" class="g-signin2" data-width="400" data-height="38" data-longtitle="true"></div></center>
    <p class="text-center" style="margin-top:3px;"></p>
    
    
    <!-- Facebook sign in -->
    <center><p style="margin-top:30px;">or</p></center>
 
    <div class="fb-login-button" data-max-rows="1" data-size="large" width = "550" height="38" data-button-type="continue_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="true"></div>
    

    
  
    
</div>

<!-- Google sign-in hooks -->
<script>
    var googleUser = {};
    var startApp = function() {
      gapi.load('auth2', function(){
        // Retrieve the singleton for the GoogleAuth library and set up the client.
        auth2 = gapi.auth2.init({
          client_id: '331432826-ohvbivkvfi8t6gsblg0270kerse7m404.apps.googleusercontent.com',
          cookiepolicy: 'single_host_origin'
        });
        attachSignin(document.getElementById('googleLogin'));
      });
    };

    function attachSignin(element) {
        console.log(element.id);
        auth2.attachClickHandler(element, {},
            function (googleUser) {
                // document.getElementById('name').innerText = "Signedin:" +
                //  googleUser.getBasicProfile().getName();
                  console.log('Email' + googleUser.getBasicProfile().getEmail());
                  $.post("./welcome", {
                      "method": "google",
                      "username"  : googleUser.getBasicProfile().getName(),
                      "email" : googleUser.getBasicProfile().getEmail(), 
                  });
            }, function(error1) {
              console.log(JSON.stringify(error1, undefined, 2));
            });
    }
    
    function signOut(){
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function (){
            console.log('User signed out.');
            document.getElementById('name').innerText = "";
        });
    }
    
    

    $(document).ready(function(){
        startApp();
    });
</script>

<!-- FB sign-in hooks -->

<script>
    
    // Called once we have the result of FB.getLoginStatus or FB.login
    function fbLoginCallback(response) {
        console.log('fbLoginCallback');
        if (response.status === 'connected') {
            console.log('login response: ' + JSON.stringify(response));
            FB.api('/me', {fields: 'name,email'}, function(response) {
                console.log('/me response: ' + JSON.stringify(response));
                $.post("./welcome",{
                    "method": "facebook",
                    "username": response.name,
                    "email": response.email
                });
            });
        } else {
            console.log("fbLoginCallback: user is not connected");
        }
    }

    // Someone clicked login with facebook. First check if the user is 
    // already logged in, if not open a prompt.
    function checkFbStatus() {
        FB.getLoginStatus(function(response) {
            if (response.status === 'connected') {
                console.log('checkFbStatus: already connected');
                fbLoginCallback(response)
            } else {
                console.log('checkFbStatus: not yet connected, using FB.login()');
                FB.login(fbLoginCallback, {scope: 'public_profile,email'});
            }
        });
    }
    
    // Log out from facebook, purely for testing purposes.
    function fbLogout() {
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
            if (response.status === 'connected') {
                console.log('fbLogout: connected, logging out..');
                FB.logout();
            } else {
                console.log('fbLogout: already logged out');
            }
        });
    }

    // Load & initialize the facebook library, pass it our appId
    
    window.fbAsyncInit = function() {
        FB.init({
          appId  : '180085452780493',
          cookie : true,  // enable cookies to allow server to access session
          xfbml  : true,  // parse social plugins on this page
          version: 'v2.8' // use graph api version 2.8
        });
    };

    (function(d, s, id) {
      var js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id)) return;
      js = d.createElement(s); js.id = id;
      js.src = "//connect.facebook.net/en_US/sdk.js";
      fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>
<c:if test="${error1 != null}">
    <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 500px; margin: 0px auto;">
        ${error1}
    </div>
</c:if>
                        </div>
                    </div>
                
            
    <div class="col-sm-1 middle-border"></div>
        <div class="col-sm-1"></div>
            <div class="col-sm-5">
                <div class="form-box">
                    <div class="form-top">
	                <div class="form-top-left">
	                    <h3>Sign up now</h3>
	                    <p>Fill in the form below to get instant access:</p>
	                </div>
	                <div class="form-top-right">
	                    <i class="fa fa-pencil"></i>
	                </div>
	            </div>
	            <div class="form-bottom">
                        <form method="POST" action="./register" accept-charset="UTF-8" role="form" id="registration-form" class="registration-form">

				                    	<div class="form-group">
				                        	<label class="sr-only" for="email">Email</label>
                                                                <input type="text" name="email" placeholder="Email (Mandatory)..." class="form-control" id="email">
				                        </div>
                                                        <div class="form-group">
				                        	<label class="sr-only" for="form-username">Username</label>
				                        	<input type="text" name="username" placeholder="Username (Mandatory)..." class="form-control" id="form-username">
				                        </div>
                                                        <div class="form-group">
				                        	<label class="sr-only" for="form-pwd">Password</label>
				                        	<input type="password" name="password" placeholder="Password (Mandatory)..." class="form-control" id="form-pwd">
				                        </div>
                                                        <div class="form-group">
				                        	<label class="sr-only" for="form-confirmpassword">Confirm Password</label>
				                        	<input type="password" name="confirmpassword" placeholder="Confirm Password as above (Mandatory)..." class="form-control" id="form-confirmpassword">
				                        </div>
                                                        <div class="form-group">
				                    		<label class="sr-only" for="form-first-name">First name</label>
				                        	<input type="text" name="first-name" placeholder="First name (Mandatory)..." class="form-control" id="form-first-name">
				                        </div>
                                                        <div class="form-group">
				                    		<label class="sr-only" for="form-last-name">Last name</label>
				                        	<input type="text" name="last-name" placeholder="Last name (Mandatory)..." class="form-control" id="form-last-name">
				                        </div>
                                                         <div class="form-check">
				                        	<p style="margin-top:30px;">Gender (Mandatory) :</p>
                                                                <label class="form-check-label" for="form-gender">
                                                                    <input class="form-check-input" type="radio" name="optionsRadios"  id="optionsRadios1" value="1" checked>Male</label>
				                        </div>
                                                        <div class="form-check"> 
                                                                <label class="form-check-label" for="form-gender">
                                                                    <input class="form-check-input" type="radio" name="optionsRadios" id="optionsRadios2" value="2">Female</label>
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-country">Country (optional)</label>
                                                                <select class="form-control" name="country" style="border-radius: 0 0 4px 4px">
                                                                <option value="Afghanistan">Afghanistan</option>
                                                                <option value="Albania">Albania</option>
                                                                <option value="Algeria">Algeria</option>
                                                                <option value="American Samoa">American Samoa</option>
                                                                <option value="Andorra">Andorra</option>
                                                                <option value="Angola">Angola</option>
                                                                <option value="Anguilla">Anguilla</option>
                                                                <option value="Antarctica">Antarctica</option>
                                                                <option value="Antigua and Barbuda">Antigua and Barbuda</option>
                                                                <option value="Argentina">Argentina</option>
                                                                <option value="Armenia">Armenia</option>
                                                                <option value="Aruba">Aruba</option>
                                                                <option value="Australia">Australia</option>
                                                                <option value="Austria">Austria</option>
                                                                <option value="Azerbaijan">Azerbaijan</option>
                                                                <option value="Bahamas">Bahamas</option>
                                                                <option value="Bahrain">Bahrain</option>
                                                                <option value="Bangladesh">Bangladesh</option>
                                                                <option value="Barbados">Barbados</option>
                                                                <option value="Belarus">Belarus</option>
                                                                <option value="Belgium" selected>Belgium</option>
                                                                <option value="Belize">Belize</option>
                                                                <option value="Benin">Benin</option>
                                                                <option value="Bermuda">Bermuda</option>
                                                                <option value="Bhutan">Bhutan</option>
                                                                <option value="Bolivia">Bolivia</option>
                                                                <option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
                                                                <option value="Botswana">Botswana</option>
                                                                <option value="Bouvet Island">Bouvet Island</option>
                                                                <option value="Brazil">Brazil</option>
                                                                <option value="Brunei Darussalam">Brunei Darussalam</option>
                                                                <option value="Bulgaria">Bulgaria</option>
                                                                <option value="Burkina Faso">Burkina Faso</option>
                                                                <option value="Burundi">Burundi</option>
                                                                <option value="Cambodia">Cambodia</option>
                                                                <option value="Cameroon">Cameroon</option>
                                                                <option value="Canada">Canada</option>
                                                                <option value="Cape Verde">Cape Verde</option>
                                                                <option value="Cayman Islands">Cayman Islands</option>
                                                                <option value="Central African Republic">Central African Republic</option>
                                                                <option value="Chad">Chad</option>
                                                                <option value="Chile">Chile</option>
                                                                <option value="China">China</option>
                                                                <option value="Christmas Island">Christmas Island</option>
                                                                <option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option>
                                                                <option value="Colombia">Colombia</option>
                                                                <option value="Comoros">Comoros</option>
                                                                <option value="Congo">Congo</option>
                                                                <option value="Cook Islands">Cook Islands</option>
                                                                <option value="Costa Rica">Costa Rica</option>
                                                                <option value="CŸte d'Ivoire">CŸte d'Ivoire</option>
                                                                <option value="Croatia">Croatia</option>
                                                                <option value="Cuba">Cuba</option>
                                                                <option value="Cura¡ao">Cura¡ao</option>
                                                                <option value="Cyprus">Cyprus</option>
                                                                <option value="Czech Republic">Czech Republic</option>
                                                                <option value="Denmark">Denmark</option>
                                                                <option value="Djibouti">Djibouti</option>
                                                                <option value="Dominica">Dominica</option>
                                                                <option value="Dominican Republic">Dominican Republic</option>
                                                                <option value="Ecuador">Ecuador</option>
                                                                <option value="Egypt">Egypt</option>
                                                                <option value="El Salvador">El Salvador</option>
                                                                <option value="Equatorial Guinea">Equatorial Guinea</option>
                                                                <option value="Eritrea">Eritrea</option>
                                                                <option value="Estonia">Estonia</option>
                                                                <option value="Ethiopia">Ethiopia</option>
                                                                <option value="Falkland Islands (Malvinas)">Falkland Islands (Malvinas)</option>
                                                                <option value="Faroe Islands">Faroe Islands</option>
                                                                <option value="Fiji">Fiji</option>
                                                                <option value="Finland">Finland</option>
                                                                <option value="France">France</option>
                                                                <option value="French Guiana">French Guiana</option>
                                                                <option value="French Polynesia">French Polynesia</option>
                                                                <option value="French Southern Territories">French Southern Territories</option>
                                                                <option value="Gabon">Gabon</option>
                                                                <option value="Gambia">Gambia</option>
                                                                <option value="Georgia">Georgia</option>
                                                                <option value="Germany">Germany</option>
                                                                <option value="Ghana">Ghana</option>
                                                                <option value="Gibraltar">Gibraltar</option>
                                                                <option value="Greece">Greece</option>
                                                                <option value="Greenland">Greenland</option>
                                                                <option value="Grenada">Grenada</option>
                                                                <option value="Guadeloupe">Guadeloupe</option>
                                                                <option value="Guam">Guam</option>
                                                                <option value="Guatemala">Guatemala</option>
                                                                <option value="Guernsey">Guernsey</option>
                                                                <option value="Guinea">Guinea</option>
                                                                <option value="Guinea-Bissau">Guinea-Bissau</option>
                                                                <option value="Guyana">Guyana</option>
                                                                <option value="Haiti">Haiti</option>
                                                                <option value="Honduras">Honduras</option>
                                                                <option value="Hong Kong">Hong Kong</option>
                                                                <option value="Hungary">Hungary</option>
                                                                <option value="Iceland">Iceland</option>
                                                                <option value="India">India</option>
                                                                <option value="Indonesia">Indonesia</option>
                                                                <option value="Iran">Iran</option>
                                                                <option value="Iraq">Iraq</option>
                                                                <option value="Ireland">Ireland</option>
                                                                <option value="Israel">Israel</option>
                                                                <option value="Italy">Italy</option>
                                                                <option value="Jamaica">Jamaica</option>
                                                                <option value="Japan">Japan</option>
                                                                <option value="Jersey">Jersey</option>
                                                                <option value="Jordan">Jordan</option>
                                                                <option value="Kazakhstan">Kazakhstan</option>
                                                                <option value="Kenya">Kenya</option>
                                                                <option value="Kiribati">Kiribati</option>
                                                                <option value="South Korea">South Korea</option>
                                                                <option value="Kuwait">Kuwait</option>
                                                                <option value="Kyrgyzstan">Kyrgyzstan</option>
                                                                <option value="Latvia">Latvia</option>
                                                                <option value="Lebanon">Lebanon</option>
                                                                <option value="Lesotho">Lesotho</option>
                                                                <option value="Liberia">Liberia</option>
                                                                <option value="Libya">Libya</option>
                                                                <option value="Liechtenstein">Liechtenstein</option>
                                                                <option value="Lithuania">Lithuania</option>
                                                                <option value="Luxembourg">Luxembourg</option>
                                                                <option value="Macao">Macao</option>
                                                                <option value="Macedonia">Macedonia</option>
                                                                <option value="Madagascar">Madagascar</option>
                                                                <option value="Malawi">Malawi</option>
                                                                <option value="Malaysia">Malaysia</option>
                                                                <option value="Maldives">Maldives</option>
                                                                <option value="Mali">Mali</option>
                                                                <option value="Malta">Malta</option>
                                                                <option value="Marshall Islands">Marshall Islands</option>
                                                                <option value="Martinique">Martinique</option>
                                                                <option value="Mauritania">Mauritania</option>
                                                                <option value="Mauritius">Mauritius</option>
                                                                <option value="Mayotte">Mayotte</option>
                                                                <option value="Mexico">Mexico</option>
                                                                <option value="Moldova, Republic of">Moldova, Republic of</option>
                                                                <option value="Monaco">Monaco</option>
                                                                <option value="Mongolia">Mongolia</option>
                                                                <option value="Montenegro">Montenegro</option>
                                                                <option value="Montserrat">Montserrat</option>
                                                                <option value="Morocco">Morocco</option>
                                                                <option value="Mozambique">Mozambique</option>
                                                                <option value="Myanmar">Myanmar</option>
                                                                <option value="Namibia">Namibia</option>
                                                                <option value="Nauru">Nauru</option>
                                                                <option value="Nepal">Nepal</option>
                                                                <option value="Netherlands">Netherlands</option>
                                                                <option value="New Caledonia">New Caledonia</option>
                                                                <option value="New Zealand">New Zealand</option>
                                                                <option value="Nicaragua">Nicaragua</option>
                                                                <option value="Niger">Niger</option>
                                                                <option value="Nigeria">Nigeria</option>
                                                                <option value="Niue">Niue</option>
                                                                <option value="Norfolk Island">Norfolk Island</option>
                                                                <option value="Northern Mariana Islands">Northern Mariana Islands</option>
                                                                <option value="Norway">Norway</option>
                                                                <option value="Oman">Oman</option>
                                                                <option value="Pakistan">Pakistan</option>
                                                                <option value="Palau">Palau</option>
                                                                <option value="Palestinian Territory, Occupied">Palestinian Territory, Occupied</option>
                                                                <option value="Panama">Panama</option>
                                                                <option value="Papua New Guinea">Papua New Guinea</option>
                                                                <option value="Paraguay">Paraguay</option>
                                                                <option value="Peru">Peru</option>
                                                                <option value="Philippines">Philippines</option>
                                                                <option value="Pitcairn">Pitcairn</option>
                                                                <option value="Poland">Poland</option>
                                                                <option value="Portugal">Portugal</option>
                                                                <option value="Puerto Rico">Puerto Rico</option>
                                                                <option value="Qatar">Qatar</option>
                                                                <option value="R»union">R»union</option>
                                                                <option value="Romania">Romania</option>
                                                                <option value="Russian Federation">Russian Federation</option>
                                                                <option value="Rwanda">Rwanda</option>
                                                                <option value="Saint Barth»lemy">Saint Barth»lemy</option>
                                                                <option value="Saint Kitts and Nevis">Saint Kitts and Nevis</option>
                                                                <option value="Saint Lucia">Saint Lucia</option>
                                                                <option value="Samoa">Samoa</option>
                                                                <option value="San Marino">San Marino</option>
                                                                <option value="Sao Tome and Principe">Sao Tome and Principe</option>
                                                                <option value="Saudi Arabia">Saudi Arabia</option>
                                                                <option value="Senegal">Senegal</option>
                                                                <option value="Serbia">Serbia</option>
                                                                <option value="Seychelles">Seychelles</option>
                                                                <option value="Sierra Leone">Sierra Leone</option>
                                                                <option value="Singapore">Singapore</option>
                                                                <option value="Slovakia">Slovakia</option>
                                                                <option value="Slovenia">Slovenia</option>
                                                                <option value="Solomon Islands">Solomon Islands</option>
                                                                <option value="Somalia">Somalia</option>
                                                                <option value="South Africa">South Africa</option>
                                                                <option value="South Sudan">South Sudan</option>
                                                                <option value="Spain">Spain</option>
                                                                <option value="Sri Lanka">Sri Lanka</option>
                                                                <option value="Sudan">Sudan</option>
                                                                <option value="Suriname">Suriname</option>
                                                                <option value="Svalbard and Jan Mayen">Svalbard and Jan Mayen</option>
                                                                <option value="Swaziland">Swaziland</option>
                                                                <option value="Sweden">Sweden</option>
                                                                <option value="Switzerland">Switzerland</option>
                                                                <option value="Syrian Arab Republic">Syrian Arab Republic</option>
                                                                <option value="Taiwan, Province of China">Taiwan, Province of China</option>
                                                                <option value="Tajikistan">Tajikistan</option>
                                                                <option value="Tanzania, United Republic of">Tanzania, United Republic of</option>
                                                                <option value="Thailand">Thailand</option>
                                                                <option value="Timor-Leste">Timor-Leste</option>
                                                                <option value="Togo">Togo</option>
                                                                <option value="Tokelau">Tokelau</option>
                                                                <option value="Tonga">Tonga</option>
                                                                <option value="Trinidad and Tobago">Trinidad and Tobago</option>
                                                                <option value="Tunisia">Tunisia</option>
                                                                <option value="Turkey">Turkey</option>
                                                                <option value="Turkmenistan">Turkmenistan</option>
                                                                <option value="Tuvalu">Tuvalu</option>
                                                                <option value="Uganda">Uganda</option>
                                                                <option value="Ukraine">Ukraine</option>
                                                                <option value="United Arab Emirates">United Arab Emirates</option>
                                                                <option value="United Kingdom">United Kingdom</option>
                                                                <option value="United States">United States</option>
                                                                <option value="Uruguay">Uruguay</option>
                                                                <option value="Uzbekistan">Uzbekistan</option>
                                                                <option value="Vanuatu">Vanuatu</option>
                                                                <option value="Venezuela, Bolivarian Republic of">Venezuela, Bolivarian Republic of</option>
                                                                <option value="Viet Nam">Viet Nam</option>
                                                                <option value="Virgin Islands, British">Virgin Islands, British</option>
                                                                <option value="Virgin Islands, U.S.">Virgin Islands, U.S.</option>
                                                                <option value="Wallis and Futuna">Wallis and Futuna</option>
                                                                <option value="Western Sahara">Western Sahara</option>
                                                                <option value="Yemen">Yemen</option>
                                                                <option value="Zambia">Zambia</option>
                                                                <option value="Zimbabwe">Zimbabwe</option>
                                                            </select>

				                        </div>
				                        
				                       
				                        <input class="btn btn-success btn-block" type="Submit" value="Sign me up!">
				                    </form>
			                    </div>
                                            <c:if test="${error2 != null}">
                                                <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 500px; margin: 0px auto;">
                                                    ${error2}
                                                </div>
                                            </c:if>
                                            <c:if test="${success != null}">
                                                <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 500px; margin: 0px auto;">
                                                    ${success}
                                                </div>
                                            </c:if>
                        	</div>
                        	
                        </div>
                    
                    </div>
                </div>
        </div>
        </div>

<%@ include file='WEB-INF/view/footer.jspf' %>