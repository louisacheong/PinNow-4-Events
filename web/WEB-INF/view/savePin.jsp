<%@ include file='header.jspf' %>
<div class="top-content">
    <div class="inner-bg">   	
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text"><h2><strong>DIY Wedding Planner</h2>
                    <h2>Save Pin Info</h2></div>
            </div>
            <div class="row">
                <c:if test="${successEdit != null}">
                    <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 100%; margin: 0px auto;">
                    ${successEdit}
                    </div>
                </c:if>
            </div>
                <div class="col-sm-5">
                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Search for a Board for Pin</h3><h5><p><c:out value="${pin.pinsPK.name}"/>:</p></h5>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-thumb-tack"></i>
                            </div>
                        </div>
	            <div class="form-bottom">
                        <form method="POST" action="./searchBoard" accept-charset="UTF-8" role="form" id="custom-search-form" class="custom-search-form">
                            <div class="input-group custom-search-form">
                                <input type="text" name="searchtext" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                            <input class="btn btn-default" type="submit" value="Search">
                            <i class="fa fa-search"></i>
                                
                            </span>
                            </div>
                        </form>
                        <br>
                        <c:if test="${foundBoards != null}">
                            <div><h3>Results : </h3></div>
                            <table id="boardTable" width="100%" class="table-hover table-striped">
                            <c:forEach var="p" items="${foundBoards}" varStatus="iter">
                                <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                                <td>
                                    <h3><c:out value="${p.pinboardsPK.name}"></c:out></h3>
                                </td>
                                <td style="text-align: center;">
                                    <a type="button" class="btn btn-primary" href="./saveOnBoard?boardName=${p.pinboardsPK.name}"><i class="fa fa-save fa-fw"></i></a>
                                </td>
                                <td style="text-align: center;">
                                    <a type="button" class="btn btn-primary" href="./editBoard?boardName=${p.pinboardsPK.name}"><i class="fa fa-pencil fa-fw"></i></a>
                                </td>
                                <td style="text-align: center;">
                                    <a type="button" class="btn btn-primary" href="./removeBoard?boardName=${p.pinboardsPK.name}"><i class="fa fa-trash fa-fw"></i></a>
                                </td>         
                                </tr>
                            </c:forEach>
                            </table>
                            </c:if>
                        </div>
                            <c:if test="${searcherror != null}">
                                <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 100%; margin: 0px;">
                                    ${searcherror}</div>
                            </c:if>
                            <c:if test="${boardstatus != null}">
                                <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 100%; margin: 0px;">
                                    ${boardstatus}</div>
                            </c:if>
                    </div>
                </div>
        <div class="col-sm-1 middle-border"></div>
        <div class="col-sm-1"></div>                	
                      
        <div class="col-sm-5">
            <div class="form-box">
                    <div class="form-top">
	                <div class="form-top-left">
	                    <h3>Create Board :</h3>
	                </div>
                        <div class="form-top-right">
	                    <i class="fa fa-plus-circle"></i>
	                </div>
                    </div>
                    <div class="form-bottom">
                        <form method="POST" action="./savePin" accept-charset="UTF-8" role="form" id="custom-boardname" class="custom-boardname-form">
                                <div class="form-group">
                                <label for="boardname">Boardname </label>
                                <input type="text" name="boardname" class="form-control" placeholder="Like 'Churches' or 'Wedding Themes' " value="${boardname}">
                                </div>
                                <div class="form-group">
                                <label for="switch">Secret </label>
                                <div class="onoffswitch">
                                    <input type="checkbox" name="isPrivate" class="onoffswitch-checkbox" id="myonoffswitch" value="false">
                                    <label class="onoffswitch-label" for="myonoffswitch">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div> 
                                <p></p>  
                                 <input class="btn btn-primary btn-block" type="Submit" value="Create Board!">
                                </div>
                        </form>
                        
                    </div>
            </div>
        </div>
        </div>
    </div>
</div>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCSfmXDopoIVNIHaNZl-nOZhxaVT2cZiXc&callback=codeAddress"></script>
<%@ include file='footer.jspf' %>