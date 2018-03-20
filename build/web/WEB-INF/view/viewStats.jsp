
<%@ include file='header.jspf' %>

<div class="top-content">
    <div class="inner-bg">   	
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text"><h2><strong>PinNow 4 Events</h2>
                    <h2>Statistics</h2></div>
                <ul class="nav navbar-nav navbar-right">
                        <h3><c:out value="${sessionScope.user}"/></h3>
                        <li style="font-"><a href="${pageContext.request.contextPath}/editUser">Settings</a></li>
                        <li><a href="${pageContext.request.contextPath}/viewStats">Statistics</a></li>
                        <li><a href="index.jsp">Log out</a></li>

                    </ul>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Number of Login Times : <c:out value="${loginCount}" /></h3>
                                
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-key"></i>
                            </div>
                        </div>
                       
                        
       
    

<%@ include file='footer.jspf' %>