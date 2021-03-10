srcDic =
{
	"Home" : "html/home.html",
	"Programs" : "html/program.html",
	"Admission" : "html/admission.html",
	"Event" : "html/event.html",
	"Contact" : "html/contact.html"
};

function setBodyDiv(getIt)
{
	$('.bodyDiv').load(srcDic[getIt]);
}
function riaction()
{
	var name = $('#name').val();
	var email = $('#email').val();
	var phone = $('#phone').val();
	var courses = $('#courses').val();
	var msg = $('#msg').val();
	$.ajax(
	{
		url : "Riaction.action",
		type : "POST",
		data: {"name" : name,"email" : email,"phone" : phone,"courses" : courses,"msg" : msg},
		success : function(data)
		{
			console.log(data);
		}
	});
}

function contactus()
{
	var name = $('#name').val();
	var email = $('#email').val();
	var phone = $('#phone').val();
	var msg = $('#msg').val();
	$.ajax(
	{
		url : "Contactus.action",
		type : "POST",
		data: {"name" : name,"email" : email,"phone" : phone,"msg" : msg},
		success : function(data)
		{
			console.log(data);
		}
	});
}