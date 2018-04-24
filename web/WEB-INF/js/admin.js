
    function drawMap() {
      var data = google.visualization.arrayToDataTable([
        ['Country', 'Population'],
        ['China', 'China: 1,363,800,000'],
        ['India', 'India: 1,242,620,000'],
        ['US', 'US: 317,842,000'],
        ['Indonesia', 'Indonesia: 247,424,598'],
        ['Brazil', 'Brazil: 201,032,714'],
        ['Pakistan', 'Pakistan: 186,134,000'],
        ['Nigeria', 'Nigeria: 173,615,000'],
        ['Bangladesh', 'Bangladesh: 152,518,015'],
        ['Russia', 'Russia: 146,019,512'],
        ['Japan', 'Japan: 127,120,000']
      ]);

    var options = {
      showTooltip: true,
      showInfoWindow: true
    };
    options['dataMode']='regions';
    var container = document.getElementById('regions_div');
    var map = new google.visualization.GeoChart(container);

    map.draw(data, options);
    
    $(document).ready(function(){
    google.charts.load('current',{'packages':['geochart']});
    google.charts.setOnLoadCallback(drawMap);       
  }
  
$(document).ready(function addNewTopic(){
      var x;
      var topic = prompt("Please enter new topic","Wedding Ideas");
      if (topic != null){
          x = "Topic : " + topic + " is created!";
          document.getElementById("addNewTopic_status").innerHTML= x;
      }
  });
  