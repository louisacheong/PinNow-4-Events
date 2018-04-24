<%@ include file='header.jspf' %>

<div class="top-content">
    <div class="inner-bg">   	
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text"><h2><strong>DIY Wedding Planner</h2>
                    <h2>Edit Board Info</h2>
                </div>
     <div class="row">       
         <div class="col-lg-4"></div>
            <div class="col-lg-4">
                <div class="form-box">
                    
	            <div class="form-bottom">
                        <form method="POST" action="./editBoard" accept-charset="UTF-8" role="form" id="edit-form" class="form-edit">
                            <div class="form-group">
                                <label for="boardName">Board Name :</label>
                                <input type="text" readonly name="boardName" value="${board.pinboardsPK.name}" class="form-control" id="form-pinname" >
                            </div>
                            <div class="form-group">
                                <label for="switch">Secret </label>
                                <c:if test="${board.isPrivate==false}">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="isPrivate" class="onoffswitch-checkbox" id="myonoffswitch" value="false">
                                    <label class="onoffswitch-label" for="myonoffswitch">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div> 
                                </c:if>
                                 <c:if test="${board.isPrivate==true}">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="isPrivate" class="onoffswitch-checkbox" id="myonoffswitch" value="true" checked>
                                    <label class="onoffswitch-label" for="myonoffswitch">
                                        <div class="onoffswitch-inner"></div>
                                        <div class="onoffswitch-switch"></div>
                                    </label>
                                </div> 
                                </c:if>
                                <p></p>  
                                <input class="btn btn-primary btn-block" type="Submit" value="Edit Board!">
                            </div>
                        </form>
			                    </div>
			                    </div>
                        	</div>
                        	
                        </div>
                    <div class="col-sm-4"></div>
                    </div>
                </div>
        </div>

<%@ include file='footer.jspf' %>