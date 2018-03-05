$(document).ready(function () {
$('.fileclass').click(function(){  
	var data = {
		"fileName" : $(this).attr("data-fileName")
	};
	
	$.ajax({
    type: "GET",
    dataType: "json",
    url: "/readFrequentWordFromFile",
    data: data,
    success: function(data) {
      $("#filedata").html(
        "<table><tbody><th>File Name</th><th>Frequent Words</th><th>Total Words in file</th><tr><td> " + data.fileName + " </td><td>"+drawWords(data.frequentWords)+"</td><td>"+data.totalWordsInFile+"</tr></tbody></table>"
      );
    }
  });
});
});

function drawWords(frequentWords) {
	var val="";
	for (var i = 0; i < frequentWords.length; i++) {
	       var word =  frequentWords[i].word +"="+frequentWords[i].wordCount;
	       val = val +" "+ word;
	    }
	return val;
}