<%@ include file='header.jspf' %>

<div class="top-content">
    <div class="inner-bg">   	
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text"><h2><strong>DIY Wedding Planner</h2>
                    <h2>Edit Pin Info</h2>
                </div>
     <div class="row">       
         <div class="col-lg-4"></div>
            <div class="col-lg-4">
                <div class="form-box">
                    
	            <div class="form-bottom">
                        <form method="POST" action="./editPin" accept-charset="UTF-8" role="form" id="edit-form" class="form-edit">
                            <div class="form-group">
                                <label for="pinName">PinName :</label>
                                <input readonly type="text" name="pinName" value="${pin.pinsPK.name}" class="form-control" id="form-pinname" >
                            </div>
                            <div class="form-group">
                                <label for="topic">Topic :</label>
                                <input readonly type="text" name="topicName" value="${pin.pinsPK.topicsName}" class="form-control" id="form-topicsname" >
                            </div>
                            
                            <div class="form-group">
                                <label for="description">Description (Optional) :</label>
				<input type="text" name="description" value="${pin.description}" class="form-control" id="form-description">
                            </div>
                            <div class="form-group">
                                <label for="location">Location where pin is taken (Optional) :</label>
                                <input id="address" name="location" type="text" value="${pin.location}">
                                <input type="button" value="Encode" onclick="codeAddress()">
                            </div>
                            <div id="map" style="width:350px;height:350px">
                            </div>
                                                        <script>
                                                            var geocoder;
                                                            var map;
                                                            function initialize() {
                                                                geocoder = new google.maps.Geocoder();
                                                                var latlng = new google.maps.LatLng(51.2194475, 4.4024643);
                                                                var mapOptions = {
                                                                    zoom: 8,
                                                                    center: latlng
                                                            }
                                                            map = new google.maps.Map(document.getElementById('map'), mapOptions);
                                                            }

                                                            function codeAddress() {
                                                                geocoder = new google.maps.Geocoder();
                                                                
                                                                var mapOptions = {
                                                                    zoom: 8,
                                                                    
                                                                }
                                                                var address = document.getElementById('address').value;
                                                                geocoder.geocode( { 'address': address}, function(results, status) {
                                                                    if (status == 'OK') {
                                                                        map = new google.maps.Map(document.getElementById('map'), mapOptions);
                                                                        map.setCenter(results[0].geometry.location);
                                                                        var marker = new google.maps.Marker({
                                                                            map: map,
                                                                            position: results[0].geometry.location
                                                                        });
                                                                        
                                                                    } else {
                                                                        console.log('Geocode was not successful for the following reason: ' + status);
                                                                    }
                                                                });
                                                            }
                                                    </script>
                            <p></p>  
                            <input class="btn btn-success btn-block" type="Submit" value="Save Changes">
                            </form>
			                    </div>
                                            <c:if test="${success != null}">
                                                <div class="btn bg-success" style="padding: 15px; border-radius: 4px; color:black; max-width: 500px; margin: 0px auto;">
                                                    ${success}
                                                </div>
                                            </c:if>
			                    </div>
                        	</div>
                        	
                        </div>
                    <div class="col-sm-4"></div>
                    </div>
                </div>
        </div>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCSfmXDopoIVNIHaNZl-nOZhxaVT2cZiXc&callback=codeAddress"></script>
<%@ include file='footer.jspf' %>