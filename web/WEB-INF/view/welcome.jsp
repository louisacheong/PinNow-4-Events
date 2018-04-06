
<%@ include file='header.jspf' %>

<div class="top-content">
    <div class="inner-bg">   	
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text"><h2><strong>PinNow 4 Events</h2>
                    <h2>Welcome Page</h2></div>
                
                    <ul class="nav navbar-nav navbar-right">
                        <h3><c:out value="${sessionScope.user}"/></h3>
                        <li style="font-"><a href="${pageContext.request.contextPath}/editUser">Settings</a></li>
                        <li><a href="${pageContext.request.contextPath}/viewProfile">Profile</a></li>
                        <li><a href="index.jsp">Log out</a></li>

                    </ul>
               
            </div>
  
<div class="masonry">
        <div class="item"><img src="img/WeddingImg5.jpg"></div>
        <div class="item">
            <div class="text-box">The ring that binds.. </div>
        </div>
        <div class="item">
            <img src="http://media-cache-ec0.pinimg.com/736x/c3/10/22/c3102281f88237e7a2515099d2e6651f.jpg">
        </div>
        <div class="item">
            <img src="http://media-cache-ec0.pinimg.com/736x/0f/d0/84/0fd0847f7b48e5f16d896f62baa31b97.jpg">
        </div>
        <div class="item">
            <iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=+&amp;q=taj+mahal&amp;ie=UTF8&amp;hq=&amp;hnear=&amp;ll=27.175015,78.042155&amp;spn=0.006295,0.006295&amp;t=m&amp;output=embed"></iframe>
        </div>
        <div class="item">
            <div class="text-box"><a href="https://twitter.com/w3bits_">I tweet sometimes.</a></div>
        </div>
        <div class="item">
            <img src="http://media-cache-ak0.pinimg.com/736x/2e/7f/db/2e7fdb7ed765973407fed0b0141bb126.jpg">
            <div class="text-box">
                <h2>Thirst Quenchers</h2></div>
        </div>
        <div class="item">
            <img src="img/WeddingImg4.png">
            <div class="text-box">Lorem ipsum dolor sit amet, dicta dolore adipisci hic ipsam velit deleniti possimus cumque accusantium rerum quibusdam.</div>
        </div>
        <div class="item">
            <img src="img/WeddingImg3.png">
            <div class="text-box">Text-only masonry block.</div>
        </div>
        <div class="item">
            <iframe width="640" height="390" src="http://www.youtube.com/embed/cwGq-uy0bhI" frameborder="0" allowfullscreen=""></iframe>
        </div>
        <div class="item">
            <div class="text-box"><a href="https://plus.google.com/+w3Bits">Circle me on Google+</a></div>
        </div>
        <div class="item">
            <iframe src="http://player.vimeo.com/video/91605331" width="500" height="281" frameborder="0" webkitallowfullscreen="" mozallowfullscreen="" allowfullscreen=""></iframe>
        </div>
        <div class="item">
            <img src="img/WeddingImg2.png">
            <div class="text-box">Text-only masonry block.</div>
        </div>
        <div class="item">
            <img src="img/WeddingImg1.png">
            <div class="text-box">Text-only masonry block.</div>
        </div>

    </div>
   
    
 <script
    async defer
    data-pin-hover="true" data-pin-tall="true"
    src="//assets.pinterest.com/js/pinit.js"
></script>   
<%@ include file='footer.jspf' %>