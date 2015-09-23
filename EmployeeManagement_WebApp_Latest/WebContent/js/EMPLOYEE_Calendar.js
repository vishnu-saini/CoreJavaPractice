/* ************************************************************************
Softricks Popup Date Picker Calendar
Version: v1.82
# *************************************************************************
# COPYRIGHT NOTICE
# Copyright (c) 2000-2001 Softricks.com, All rights reserved.
# This script may be used and modified free of charge for Non-profit purposes
# by anyone as long as this copyright notice and the comments above are kept 
# in their original form. By using this script, you agree to the disclaimer 
# notices as on the softricks.com site.
#
# Selling the code for this script, without prior written consent of 
# Softricks.com, is not allowed. Redistributing this script over the internet 
# or in any medium should be done only with the written permission from 
# Softricks.com.
#
# IN ALL CASES COPYRIGHT AND HEADERS MUST REMAIN INTACT.
#
# If you plan to use the script on a commercial site/application, you should
# notify Softricks.com and verify the licensing terms.
#
# Visit the website for more information on Softricks.com's Copyright, 
# Privacy, Disclaimer and Terms of use policies.
************************************************************************ */

// IE5.0 fix for Array.push method
if (!Array.prototype.push) {
	Array.prototype.push = function() {
		for (var i=0; i<arguments.length; i++)
			this[this.length] = arguments[i];
	}
}

function name_values(instring) {
	// Assumption: ';' is a restricted character in a value.
	// Returns an array of variable names set by this function.
	var vars = new Array();
	rc = "\235";
	instring = instring.replace(/\\\;/g, rc);

	var pattern = /[a-zA-Z0-9]+\=[\/:#a-zA-Z0-9\-\+\., \235]+/gi;
	var y = instring.match(pattern);
	for (i=0; i<y.length; i++) {
		var s = y[i].split("=");
		s[1] = s[1].replace(rc, ";");
		vars[i] = "v_" + s[0];
		eval(vars[i] + " = '" + s[1] + "'");
	}
	return vars;
}

function chkVar(pvarname) {
	if (eval(pvarname) && eval(pvarname) != "")
		return true;
	else
		return false;
}

function chkArg(parg) {
	if (parg == 'undefined' || parg == null || parg == "")
		return false;
	else
		return true;
}

function arrayElt(pArr, pElt) {
	// Assumes a string array and a string element.
	for (j=0; j<pArr.length; j++) {
		if (pArr[j].toUpperCase() == pElt.toUpperCase())
			return j;
	}

	return "-1";
}

var onClickFnCode = "";
var orig_onClickFnCode = "";

// This is a Dynamic function. Its function code is constructed 
// in onclickfn method and set in the show method.
// This function is here in the same way as the function we 
// construct in the calendar window in case of POPUP calendar.
// This is for the INLINE calendar - used to append selected dates

// Functions for the INLINE calendar 
// which get dynamically generated for the POPUP.
// ====================
function onClickFn(pday) {
	var re = /pday/;
	onClickFnCode = orig_onClickFnCode;
	onClickFnCode = onClickFnCode.replace(re, "'" + pday + "'");
	eval(onClickFnCode);
}
function kdwn(pthis) {
	if (event.keyCode == 13) pthis.onchange(); 
	else return false;
}
// ====================

function Today() {
	var d = new Date();
	return ((d.getMonth() + 1) + "/" + d.getDate() + "/" + d.getFullYear());
}

function dateAdd(indt, days, sign) {

	
	var d = new Date(indt);
	var dv = d.valueOf();
	var ndv;
	if (sign == "+")
		ndv = dv + (days*(1000*60*60*24));
	else
		ndv = dv - (days*(1000*60*60*24));
	var nd = new Date(ndv);
	return ((nd.getMonth() + 1) + "/" + nd.getDate() + "/" + nd.getFullYear());
}

function IESplit(re, st) {
	var found;
	var ret = new Array();
	var pos;

	while ((x=re.exec(st)) != null) {
		ret.push(st.substring(0, st.indexOf(x[1])));
		ret.push(x[1]);
		st = st.substr(st.indexOf(x[1]) + x[1].length);
	}
	return ret;
}

// Custom parameters set by the 6th argument to show_calendar function.
// CUSTOM STRING
var v_CloseOnSelect, v_AppendOrReplace, v_AppendChar, v_ReturnData;
var v_InlineX, v_InlineY, v_Title, v_CurrentDate, v_AllowWeekends;
var v_Resizable, v_Width, v_Height, v_SelectAfter, v_NSHierarchy;
var v_SelectBefore, v_CallFunction, v_PopupX, v_PopupY;
var v_Nav, v_SmartNav, v_Fix, v_WeekStart, v_Weekends;

var weekend = new Array();
var weekendColor = "#B7B7C7";
//var fontface = "Courier New";
var fontface = "Verdana";
//var fontface = "Arial";
var fontsize = 1;

var gNow = new Date();
var ggWinCal;           // Really global variable pointing to the calendar window

// Drag-n-Drop Variables
var theLayer;
var theLayerStyle;		// Style used for positioning in IE.

var currX, currY;
var cx, cy;				// Client co-ords
var x, y;				// Co-ords of the point at first click
var incrX, incrY;

var mDown, mUp;
// ----------- VARIABLE DECLARATIONS END -----------

// Browser Detection
isNav = (navigator.appName.indexOf("Netscape") != -1) ? true : false;
isIE = (navigator.appName.indexOf("Microsoft") != -1) ? true : false;
isDOM = (document.getElementById) ? true : false;

// Month names in YOUR Language (French/Spanish..)
Calendar.Months = ["January", "February", "March", "April", "May", "June",
	"July", "August", "September", "October", "November", "December"];
// Short Month names in YOUR Language
Calendar.SMonths = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
	"Sep", "Oct", "Nov", "Dec"];
// Month names in English
Calendar.EMonths = ["January", "February", "March", "April", "May", "June",
	"July", "August", "September", "October", "November", "December"];

// Non-Leap year Month days..
Calendar.DOMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
// Leap year Month days..
Calendar.lDOMonth = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
Calendar.DOW = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
Calendar.count = 0;

// For inline calendar, the default contents of the layer. (v1.3)
Calendar.gInitText = "EMPLOYEE Calendar";

function Calendar(p_item, p_WinCal, p_month, p_year, p_format, p_type) {

	// Argument p_type defines if the calendar is popup or inline
	// If p_type is INLINE, 
	//    you must pass p_inline parameter which specifies the name of the layer 
	//    which displays the calendar inline.
	//    --->

	if ((p_month == null) && (p_year == null))      return;

	if (p_WinCal == null)
		this.gWinCal = ggWinCal;
	else
		this.gWinCal = p_WinCal;

	if (p_month == null) {
		this.gMonthName = null;
		this.gMonth = null;
		this.gYearly = true;
	} else {
		this.gMonthName = Calendar.get_month(p_month);
		this.gMonth = new Number(p_month);
		this.gYearly = false;
	}
	
	if (p_type == null)
		this.gType = "POPUP";		// Default is popup
	else
		this.gType = p_type;

	if (this.gType == "INLINE") {
		this.WHO = "";
		this.INLINE = "Calendar";	// Inline Calendar Layer name
		this.codeINLINE = "";		// Calendar code will be constructed in this var
	} else
		this.WHO = "window.opener.";

	this.gYear = p_year;
	this.gFormat = p_format;
	this.gBGColor = "white";
	this.gFGColor = "black";
	this.gTextColor = "black";
	this.gHeaderColor = "black";
	this.gReturnItem = p_item;
	this.gTitle = "Softricks.com Calendar";
}

Calendar.get_month = Calendar_get_month;
Calendar.get_daysofmonth = Calendar_get_daysofmonth;
Calendar.get_dow = Calendar_get_dow;
Calendar.calc_month_year = Calendar_calc_month_year;
Calendar.CreateCalendarLayer = Calendar_CreateCalendarLayer;
Calendar.Close = Calendar_Close;
Calendar.Lwwrite = Calendar_Lwwrite;
Calendar.MoveTo = Calendar_MoveTo;
Calendar.isWeekend = Calendar_isWeekend;
Calendar.processDateData = Calendar_processDateData;
Calendar.readDate = Calendar_readDate;

function Calendar_get_month(monthNo, pLanguage) {
if (!pLanguage || pLanguage=="E")
	return Calendar.EMonths[monthNo];
else
	return Calendar.Months[monthNo];
}

function Calendar_get_dow(dayNo) {
	return Calendar.DOW[dayNo];
}

function Calendar_get_daysofmonth(monthNo, p_year) {
	/* 
	Check for leap year ..
	1.Years evenly divisible by four are normally leap years, except for... 
	2.Years also evenly divisible by 100 are not leap years, except for... 
	3.Years also evenly divisible by 400 are leap years. 
	*/
	if ((p_year % 4) == 0) {
			if ((p_year % 100) == 0 && (p_year % 400) != 0)
					return Calendar.DOMonth[monthNo];

			return Calendar.lDOMonth[monthNo];
	} else
			return Calendar.DOMonth[monthNo];
}

function Calendar_calc_month_year(p_Month, p_Year, incr) {
	/* 
	Will return an 1-D array with 1st element being the calculated month 
	and second being the calculated year 
	after applying the month increment/decrement as specified by 'incr' parameter.
	'incr' will normally have 1/-1 to navigate thru the months.
	*/
	var ret_arr = new Array();

	if (incr == -1) {
		// B A C K W A R D
		if (p_Month == 0) {
			ret_arr[0] = 11;
			ret_arr[1] = parseInt(p_Year, 10) - 1;
		}
		else {
			ret_arr[0] = parseInt(p_Month, 10) - 1;
			ret_arr[1] = parseInt(p_Year, 10);
		}
	} else if (incr == 1) {
		// F O R W A R D
		if (p_Month == 11) {
			ret_arr[0] = 0;
			ret_arr[1] = parseInt(p_Year, 10) + 1;
		}
		else {
			ret_arr[0] = parseInt(p_Month, 10) + 1;
			ret_arr[1] = parseInt(p_Year, 10);
		}
	}

	return ret_arr;
}

function Calendar_isWeekend(pday) {
	var i;

	for (i=0; i<weekend.length; i++) {
		if (parseInt(pday) == parseInt(weekend[i]))
			return true;
	}
	return false;
}

function Calendar_processDateData(vInputData, pFormat) {
	// InputData is of the form Today, Today+15 or Today-5 or a date value..
	var m;
	var td = Today();
	var ree = new RegExp("(Today)(([\\+\\-])([0-9]+))?", "i");
	if ((m = vInputData.match(ree)) != null) {
		if (m[1].toUpperCase() == "TODAY" && m[0].length > 5)
			return dateAdd(td, m[4], m[3]);
		else if (m[1].toUpperCase() == "TODAY")
			return td;
	} else {
		// Read the date in its format
		return Calendar.readDate(vInputData, pFormat);
	}
}

function FormatDateTime(datetime, FormatType)
/*
FomatType takes the following values
1 - General Date = Friday, October 30, 1998
2 - Typical Date = 10/30/98
3 - Standard Time = 6:31 PM
4 - Military Time = 18:31
*/
{

var strDate = new String(datetime);

if (strDate.toUpperCase() == "NOW") {
var myDate = new Date();
strDate = String(myDate);
} else {
var myDate = new Date(datetime);
strDate = String(myDate);
}


// Get the date variable parts
var Day = new String(strDate.substring(0,3));
if (Day == "Sun") Day = "Sunday";
if (Day == "Mon") Day = "Monday";
if (Day == "Tue") Day = "Tuesday";
if (Day == "Wed") Day = "Wednesday";
if (Day == "Thu") Day = "Thursday";
if (Day == "Fri") Day = "Friday";
if (Day == "Sat") Day = "Saturday";

var Month = new String(strDate.substring(4,7)), MonthNumber = 0;
if (Month == "Jan") { Month = "January"; MonthNumber = 1; }
if (Month == "Feb") { Month = "February"; MonthNumber = 2; }
if (Month == "Mar") { Month = "March"; MonthNumber = 3; }
if (Month == "Apr") { Month = "April"; MonthNumber = 4; }
if (Month == "May") { Month = "May"; MonthNumber = 5; }
if (Month == "Jun") { Month = "June"; MonthNumber = 6; }
if (Month == "Jul") { Month = "July"; MonthNumber = 7; }
if (Month == "Aug") { Month = "August"; MonthNumber = 8; }
if (Month == "Sep") { Month = "September"; MonthNumber = 9; }
if (Month == "Oct") { Month = "October"; MonthNumber = 10; }
if (Month == "Nov") { Month = "November"; MonthNumber = 11; }
if (Month == "Dec") { Month = "December"; MonthNumber = 12; }

var curPos = 11;
var MonthDay = new String(strDate.substring(8,10));
if (MonthDay.charAt(1) == " ") {
MonthDay = "0" + MonthDay.charAt(0);
curPos--;
}

var MilitaryTime = new String(strDate.substring(curPos,curPos + 5));

var Year = new String(strDate.substring(strDate.length - 4, strDate.length));

//document.write(strDate + "");

// Format Type decision time!
if (FormatType == 1)
strDate = Day + ", " + Month + " " + MonthDay + ", " + Year;
else if (FormatType == 2)
strDate = MonthNumber + "/" + MonthDay + "/" + Year;	//Year.substring(2,4);
else if (FormatType == 3) {
var AMPM = MilitaryTime.substring(0,2) >= 12 && MilitaryTime.substring(0,2) != "24" ? " PM" : " AM";
if (MilitaryTime.substring(0,2) > 12)
strDate = (MilitaryTime.substring(0,2) - 12) + ":" + MilitaryTime.substring(3,MilitaryTime.length) + AMPM;
else {
if (MilitaryTime.substring(0,2) < 10)
strDate = MilitaryTime.substring(1,MilitaryTime.length) + AMPM;
else
strDate = MilitaryTime + AMPM;
}
}
else if (FormatType == 4)
strDate = MilitaryTime;


return strDate;
}

function Calendar_readDate(indt, infmt) {
	var re = "";
	var whoarr = new Array();
	whoarr.push("Dummy");

	// The split function has problems in IE.
	// It does not include the separators
	// specified by the regular expression in the return array. Damn..!

	// var mach = infmt.split(new RegExp("(DD|MM|MONTH|MON|YYYY|YY|DOW)", "g"));
	var mach = IESplit(new RegExp("(DD|MM|MONTH|MON|YYYY|YY|DOW)"), infmt);
	for (i=0; i<mach.length; i++) {
		switch (mach[i].toUpperCase()) {
			case "DD":
				re += "(\\d{1,2})"; whoarr.push(mach[i]); break;
			case "DOW":
				re += "(MONDAY|TUESDAY|WEDNESDAY|THURSDAY|FRIDAY|SATURDAY|SUNDAY)";
				whoarr.push(mach[i]); break;
			case "MM":
				re += "(\\d{1,2})"; whoarr.push(mach[i]); break;
			case "MON":
				re += "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)";
				whoarr.push(mach[i]); break;
			case "MONTH":
				re += "(JANUARY|FEBRUARY|MARCH|APRIL|MAY|JUNE|JULY|AUGUST|SEPTEMBER|OCTOBER|NOVEMBER|DECEMBER)";
				whoarr.push(mach[i]); break;
			case "YY":
				re += "(\\d{1,2})"; whoarr.push(mach[i]); break;
			case "YYYY":
				re += "(\\d{4})"; whoarr.push(mach[i]); break;
			default:
				re += mach[i];
		}
	}
	var dpart,mpart,ypart;
	var rege = new RegExp(re, "i");
	if (rege.test(indt)) {
		var ma = indt.match(rege);
		for (i=0; i<ma.length; i++) {
			switch (whoarr[i]) {
				// Validate(whoarr[i], ma[i]);
				case "DD":
					dpart = parseInt(ma[i], 10); break;
				case "MM":
					mpart = parseInt(ma[i], 10); break;
				case "MON":
					mpart = parseInt(arrayElt(Calendar.SMonths, ma[i]), 10) + 1; break;
				case "MONTH":
					mpart = parseInt(arrayElt(Calendar.Months, ma[i]), 10) + 1; break;
				case "YY":
					ytpart = parseInt(ma[i], 10);
					ypart = ((ytpart > 20) ? (ytpart + 1900) : (ytpart + 2000)); break;
				case "YYYY":
					ypart = parseInt(ma[i], 10); break;
			}
		}
	}
	if (!(dpart||mpart||ypart))
		return null;
	else
		return(new Date(mpart+"/"+dpart+"/"+ypart));
}

function Calendar_Close(pType, pINLINE) {
	if (pType == "POPUP")
		ggWinCal.close();
	if (pType == "INLINE")
		Calendar.Lwwrite(Calendar.gInitText, pINLINE)
	
	ggWinCal = null;
}

// This is for compatibility with Navigator 3, we have to create and discard one object before the prototype object exists.
new Calendar();

Calendar.prototype.getMonthlyCalendarCode = function() {
	var vCode = "";
	var vHeader_Code = "";
	var vData_Code = "";

	// Begin Table Drawing code here..
	vCode = vCode + "<TABLE WIDTH='" + (v_Width-30) + "' BORDER=1 BGCOLOR=\"" + this.gBGColor + "\">";

	vHeader_Code = this.cal_header();
	vData_Code = this.cal_data();
	vCode = vCode + vHeader_Code + vData_Code;

	vCode = vCode + "</TABLE>";

	return vCode;
}

Calendar.prototype.onclickfn = function() {
	// This should return the code string for the onclickfn in the calendar document.
	
	// This is the reference to the return object
	// window.opener.document. / window.document. ... .value
	var whois = this.WHO + 
				((this.gType == "POPUP") ? 
				"document." + v_NSHierarchy : 
				"window.document." + v_NSHierarchy) + 
				this.gReturnItem + ".value";

	// apchar will turn out to be either " = " or " += ''" or " += ';'"
	var apchar = (this.returnMode == "Replace") ? " = " : " += ";

	var retCode = "apchar = ''" +
					((this.returnMode == "Replace") ? ";" : " + ") +
					"((" + whois + " == '') ? '' : '" + this.appendChar + "');\n" +
				whois + apchar + "apchar + pday;\n";

	return retCode;
}

Calendar.prototype.showSmartNavBar = function() {
	var selcalendar = "<table width=100% border=0 bgcolor=#b0b0f7><tr><td rowspan=2 bgcolor=#b0b0f7>";
	
	selcalendar += "<select name='selMonth' onchange=\"" + 
		this.WHO + "Build(" + 
		"'" + this.gReturnItem + "', document.frmCal.selMonth.selectedIndex, '" +  
		this.gYear + "', '" + this.gFormat + "', '" + this.gType + "');\">\n";
	for (i=0; i<12; i++) {
		selcalendar +=	"<option value=\"" + i + "\" ";
		if (parseInt(this.gMonth) == i)
			selcalendar += "selected";
		selcalendar += ">" + Calendar.Months[i] + "</option>\n";
	}
	selcalendar +=	"<\/select>\n</td><td rowspan=2 bgcolor=#b0b0f7>";

	selcalendar += "<input name=\"cy\" size=4 maxlength=4 value=\"" + this.gYear + 
		"\" onchange=\"" +
		"javascript:" + this.WHO + "Build(" + 
		"'" + this.gReturnItem + "', '" + this.gMonth + 
		"', document.frmCal.cy.value, '" + this.gFormat + "', '" + this.gType + "');\" " +
		"onkeydown=\"javascript:kdwn(this);\"" + 
		">\n";

	selcalendar += "</td><td bgcolor=#b0b0f7>" + 
		"<A HREF=\"javascript:void(0);\" onClick=\"document.frmCal.cy.value++;document.frmCal.cy.onchange();return false;\">" + 
		"<FONT FACE=Arial SIZE=1 color=white>^</FONT></A>" + 
		"</td></tr><tr><td bgcolor=#b0b0f7>" + 
		"<A HREF=\"javascript:void(0);\" onClick=\"document.frmCal.cy.value--;document.frmCal.cy.onchange();return false;\">" + 
		"<FONT FACE=Arial SIZE=1 color=white>v</FONT></A>" + 
		"</td></tr></table>";
	this.wwrite(selcalendar);
}

Calendar.prototype.show = function() {
	var vCode = "";

	if (this.gType == "POPUP")
		this.gWinCal.document.open();

	// Setup the page...
	this.wwrite("<html>");
	this.wwrite("<head><title>EMPLOYEE</title>");
	
	if (this.gType == "POPUP")
		this.wwrite("<script language='javascript'>" + 
			"function onClickFn(pday) {\n" +
			this.onclickfn() + "}\n<\/script>");
	else
		orig_onClickFnCode = this.onclickfn();

	if (v_SmartNav == "Yes" && this.gType == "POPUP")
		this.wwrite("<script language='javascript'>\n" + 
			"function kdwn(pthis) {" + 
			"if (event.keyCode == 13) pthis.onchange(); else return false;}\n" + 
			"</script>");

	this.wwrite("</head>");

	this.wwrite("<body " + 
			"link=\"" + this.gLinkColor + "\" " + 
			"vlink=\"" + this.gLinkColor + "\" " +
			"alink=\"" + this.gLinkColor + "\" " +
			"bgcolor='#E2E9F3'"+              
			"text=\"" + this.gTextColor + "\" LANGUAGE=javascript onload=\"window.focus();\">");
	
	// For Smart navigation
	if (v_SmartNav == "Yes")
		this.wwrite("<form name=\"frmCal\" onsubmit=\"return false;\">");

	this.wwrite("<TABLE WIDTH='" + (v_Width-30) + "' BORDER=0 CELLPADDING=0 BGCOLOR='#000099'><TR><TD>" +  
		"<TABLE BORDER=0 WIDTH='100%' CELLPADDING=1 BGCOLOR='#B7B7C7'>" +  
		"<TR><TD BGCOLOR='#000099'>" + 
		"<FONT COLOR=white FACE='" + fontface + "' SIZE=1><B>" + this.gTitle + "</B></FONT>" + 
		"</TD><TD BGCOLOR='#000099' ALIGN=RIGHT>" + 
		"<FONT COLOR=white FACE='" + fontface + "' SIZE=1><B>" + 
		"<A HREF='javascript:" +
		this.WHO + "Calendar.Close(\"" + this.gType + "\", \"" + this.INLINE + "\");' " +
		"STYLE='color:white'>" + 
		"x</A></B></FONT></TD></TR><TR>");
	 
	this.wwrite("<TD BGCOLOR='#B7B7C7'>");
	this.wwriteA("<FONT FACE='" + fontface + "' SIZE=1><B>");
	this.wwriteA(this.gMonthName + " " + this.gYear);
	this.wwriteA("</B></TD>");
	
	// Code to let users fix the calendar or let it move
	this.wwriteA("</TR><TR><TD COLSPAN=2>");

	if (v_SmartNav == "Yes")
		this.showSmartNavBar();
	
	// Show navigation buttons
	var prevMMYYYY = Calendar.calc_month_year(this.gMonth, this.gYear, -1);
	var prevMM = prevMMYYYY[0];
	var prevYYYY = prevMMYYYY[1];

	var nextMMYYYY = Calendar.calc_month_year(this.gMonth, this.gYear, 1);
	var nextMM = nextMMYYYY[0];
	var nextYYYY = nextMMYYYY[1];

	if (v_Nav == "Yes") {
		this.wwrite("<TABLE WIDTH='" + (v_Width-30) + "' BORDER=0 CELLSPACING=0 CELLPADDING=0 BGCOLOR='#e0e0e0'><TR><TD ALIGN=center>");

		this.wwrite("<FONT COLOR=black FACE='" + fontface + "' SIZE=1>" + 
				"[<A HREF=\"" +
				"javascript:" + this.WHO + "Build(" + 
				"'" + this.gReturnItem + "', '" + this.gMonth + "', '" + (parseInt(this.gYear, 10)-1) + "', '" + this.gFormat + "', '" + this.gType + "'" + 
				");\"><<<\/A>]</FONT></TD><TD ALIGN=center>");
		this.wwrite("<FONT COLOR=black FACE='" + fontface + "' SIZE=1>" + 
				"[<A HREF=\"" +
				"javascript:" + this.WHO + "Build(" + 
				"'" + this.gReturnItem + "', '" + prevMM + "', '" + prevYYYY + "', '" + this.gFormat + "', '" + this.gType + "'" + 
				");\"><<\/A>]</FONT></TD>");
		this.wwrite("<TD ALIGN=center>");
		this.wwrite("<FONT COLOR=black FACE='" + fontface + "' SIZE=1>" + 
				"[<A HREF=\"" +
				"javascript:" + this.WHO + "Build(" + 
				"'" + this.gReturnItem + "', '" + gNow.getMonth() + "', '" + gNow.getFullYear() + "', '" + this.gFormat + "', '" + this.gType + "'" + 
				");\">Today<\/A>]</FONT></TD><TD ALIGN=center>");
		this.wwrite("<FONT COLOR=black FACE='" + fontface + "' SIZE=1>" + 
				"[<A HREF=\"" +
				"javascript:" + this.WHO + "Build(" + 
				"'" + this.gReturnItem + "', '" + nextMM + "', '" + nextYYYY + "', '" + this.gFormat + "', '" + this.gType + "'" + 
				");\">><\/A>]</FONT></TD><TD ALIGN=center>");
		this.wwrite("<FONT COLOR=black FACE='" + fontface + "' SIZE=1>" + 
				"[<A HREF=\"" +
				"javascript:" + this.WHO + "Build(" + 
				"'" + this.gReturnItem + "', '" + this.gMonth + "', '" + (parseInt(this.gYear, 10)+1) + "', '" + this.gFormat + "', '" + this.gType + "'" + 
				");\">>><\/A>]</FONT></TD></TR></TABLE>");
	}

	// Get the complete calendar code for the month..
	vCode = this.getMonthlyCalendarCode();
	this.wwrite(vCode);

	this.wwrite("</TD></TR></TABLE></TD></TR></TABLE>");

	// For Smart navigation
	if (v_SmartNav == "Yes")
		this.wwrite("</form>");

	this.wwrite("</font></body></html>");

	if (this.gType == "POPUP")
		this.gWinCal.document.close();
		
	if (this.gType == "INLINE")
		Calendar.Lwwrite(this.codeINLINE, this.INLINE);
}

Calendar.prototype.showY = function() {
	var vCode = "";
	var i;
	var vr, vc, vx, vy;             // Row, Column, X-coord, Y-coord
	var vxf = 285;                  // X-Factor
	var vyf = 200;                  // Y-Factor
	var vxm = 10;                   // X-margin
	var vym;                        // Y-margin
	
	if (isIE)		vym = 75;
	else if (isDOM)	vym = 25;
	else if (isNav)	vym = 25;

	this.gWinCal.document.open();

	this.wwrite("<html>");
	this.wwrite("<head><title>Calendar</title>");
	this.wwrite("<style type='text/css'>\n<!--");
	for (i=0; i<12; i++) {
		vc = i % 3;
		if (i>=0 && i<= 2)      vr = 0;
		if (i>=3 && i<= 5)      vr = 1;
		if (i>=6 && i<= 8)      vr = 2;
		if (i>=9 && i<= 11)     vr = 3;

		vx = parseInt(vxf * vc) + vxm;
		vy = parseInt(vyf * vr) + vym;

		this.wwrite(".lclass" + i + " {position:absolute;top:" + vy + ";left:" + vx + ";}");
	}
	this.wwrite("-->\n</style>");

	if (this.gType == "POPUP")
		this.wwrite("<script language='javascript'>" + 
			"function onClickFn(pday) {\n" +
			this.onclickfn() + "}\n<\/script>");
	else
		orig_onClickFnCode = this.onclickfn();

	this.wwrite("</head>");

	this.wwrite("<FONT FACE='" + fontface + "' SIZE=1><B>");

	this.wwrite("Year : " + this.gYear);
	this.wwrite("</B><BR>");

	// Show navigation buttons
	var prevYYYY = parseInt(this.gYear, 10) - 1;
	var nextYYYY = parseInt(this.gYear, 10) + 1;

	this.wwrite("<TABLE WIDTH='" + (v_Width-30) + "' BORDER=1 CELLSPACING=0 CELLPADDING=0 BGCOLOR='#e0e0e0'><TR><TD ALIGN=center>");
	this.wwrite("[<A HREF=\"" +
			"javascript:window.opener.Build(" + 
			"'" + this.gReturnItem + "', null, '" + prevYYYY + "', '" + this.gFormat + "'" +
			");" +
			"\" alt='Prev Year'><<<\/A>]</TD>");
	this.wwrite("<TD ALIGN=center>");
	this.wwrite("[<A HREF=\"" +
			"javascript:window.opener.Build(" + 
			"'" + this.gReturnItem + "', null, '" + nextYYYY + "', '" + this.gFormat + "'" +
			");" +
			"\">>><\/A>]</TD></TR></TABLE><BR>");

	// Get the complete calendar code for each month..
	var j;
	for (i=11; i>=0; i--) {
		if (isIE)
			this.wwrite("<DIV ID=\"layer" + i + "\" CLASS=\"lclass" + i + "\">");
		else if (isDOM)
			this.wwrite("<DIV ID=\"layer" + i + "\" CLASS=\"lclass" + i + "\">");
		else if (isNav)
			this.wwrite("<LAYER ID=\"layer" + i + "\" CLASS=\"lclass" + i + "\">");

		this.gMonth = i;
		this.gMonthName = Calendar.get_month(this.gMonth);
		vCode = this.getMonthlyCalendarCode();
		this.wwrite(this.gMonthName + "/" + this.gYear + "<BR>");
		this.wwrite(vCode);

		if (isIE)
			this.wwrite("</DIV>");
		else if (isDOM)
			this.wwrite("</DIV>");
		else if (isNav)
			this.wwrite("</LAYER>");
	}

	this.wwrite("</font><BR></body></html>");
	this.gWinCal.document.close();
}


Calendar.prototype.cal_header = function() {
	var vCode = "";

	vCode = vCode + "<TR>";
	for (i=v_WeekStart,j=0; j<7; i++,j++,i=i%7)
		vCode = vCode + "<TD WIDTH='" + ((i==6) ? 16 : 14) + "%'>" + 
			"<FONT SIZE='1' FACE='" + fontface + "' COLOR='" + this.gHeaderColor + "'><B>" + 
			Calendar.DOW[i].substring(0, 3) + "</B></FONT></TD>";
	vCode = vCode + "</TR>";

	return vCode;
}

Calendar.prototype.cal_data = function() {
	var vDate = new Date();
	vDate.setDate(1);
	vDate.setMonth(this.gMonth);
	vDate.setFullYear(this.gYear);

	var vFirstDay = vDate.getDay();
	var vDay=1;
	var vLastDay=Calendar.get_daysofmonth(this.gMonth, this.gYear);
	var vOnLastDay=0;
	var vCode = "";
	
	var linkText = "";
	var linkCloseText = "";

	if (this.closeable) {
		closecodeP = ((this.gType=="POPUP") ? "window.close();" : "");
		closecodeI = "Calendar.Close(\"" + this.gType + "\", \"" + this.INLINE + "\"); ";
	} else {
		closecodeP = "";
		closecodeI = "void(0);' ";
	}

	var whois = this.WHO + 
				((this.gType == "POPUP") ? "document." : "window.document.") + 
				this.gReturnItem + ".value";

	/*
	Get day for the 1st of the requested month/year..
	Place as many blank cells before the 1st day of the month as necessary. 
	*/
	vCode = vCode + "<TR>";
	for (j=v_WeekStart,i=0; j!=vFirstDay; j++,i++,j=j%7) {
		vCode = vCode + "<TD WIDTH='10%'" + this.write_weekend_string(j) + "><FONT SIZE='1' FACE='" + fontface + "'>&nbsp;</FONT></TD>";
	}

	// Write rest of the 1st week
	for (j=vFirstDay; i<7; j++,i++,j=j%7) {
		vDate.setDate(vDay);

		if ((this.gAllowWeekends == "No" && Calendar.isWeekend(j)) || 
			(vDate < v_SelectAfter || vDate > v_SelectBefore)) {
					linkText = "";
					linkCloseText = "";
		} else {
			linkText = "<A HREF='javascript:" + 
				((this.CallFunction != "") ? (this.WHO + this.CallFunction + "();") : "") +
				closecodeI + "' " +
				"onClick=\"onClickFn('" + 
				
				((this.returnData == "Date") ? 
				this.format_data(vDay) : this.format_dow(vDay)) + 
				
				"');" + 
				((this.CallFunction != "") ? (this.WHO + this.CallFunction + "();") : "") +
				closecodeP +
				"return true;" + 
				"\">";
			linkCloseText = "<\/A>";
		}

		vCode = vCode + "<TD WIDTH='10%'" + this.write_weekend_string(j) + 
				"><FONT SIZE='1' FACE='" + fontface + "'>" + 
				linkText + 
				this.format_day(vDay) + 
				linkCloseText + 
				"</FONT></TD>";
		vDay = vDay + 1;
	}
	vCode = vCode + "</TR>";

	// Write the rest of the weeks
	for (k=2; k<7; k++) {
		vCode = vCode + "<TR>";

		for (j=v_WeekStart,i=0; i<7; j++,i++,j=j%7) {
			vDate.setDate(vDay);
			if ((this.gAllowWeekends == "No" && Calendar.isWeekend(j)) || 
				(vDate < v_SelectAfter || vDate > v_SelectBefore)) {
					linkText = "";
					linkCloseText = "";
			} else {
				linkText = "<A HREF='javascript:" + 
					((this.CallFunction != "") ? (this.WHO + this.CallFunction + "();") : "") +
					closecodeI + "' " +
					"onClick=\"onClickFn('" + 
				
					((this.returnData == "Date") ? 
					this.format_data(vDay) : this.format_dow(vDay)) + 
				
					"');" + 
					((this.CallFunction != "") ? (this.WHO + this.CallFunction + "();") : "") +
					closecodeP +
					"return true;" + 
					"\">";
				linkCloseText = "<\/A>";
			}

			vCode = vCode + "<TD WIDTH='10%'" + this.write_weekend_string(j) + 
					"><FONT SIZE='1' FACE='" + fontface + "'>" + 
					linkText + 
					this.format_day(vDay) + 
					linkCloseText + 
					"</FONT></TD>";
			vDay = vDay + 1;

			if (vDay > vLastDay) {
				vOnLastDay = 1;
				break;
			}
		}

		if (i == 6)
			vCode = vCode + "</TR>";
		if (vOnLastDay == 1)
			break;
	}

	// Fill up the rest of last week with proper blanks, so that we get proper square blocks
	for (m=1; m<(7-i); m++) {
		if (this.gYearly)
			vCode = vCode + "<TD WIDTH='10%'" + this.write_weekend_string(j+m) + 
				"><FONT SIZE='1' FACE='" + fontface + "' COLOR='gray'>&nbsp;</FONT></TD>";
		else
			vCode = vCode + "<TD WIDTH='10%'" + this.write_weekend_string(j+m) + 
				"><FONT SIZE='1' FACE='" + fontface + "' COLOR='gray'>" + m + "</FONT></TD>";
	}

	return vCode;
}

Calendar.prototype.format_day = function(vday) {
	var highDate;
	if (this.gCurrentDate != "NONE")
		highDate = this.gCurrentDate;
	else
		highDate = gNow;

	var vNowDay = highDate.getDate();
	var vNowMonth = highDate.getMonth();
	var vNowYear = highDate.getFullYear();

	if (vday == vNowDay && this.gMonth == vNowMonth && this.gYear == vNowYear)
			return ("<FONT COLOR=\"RED\"><B>" + vday + "</B></FONT>");
	else
			return (vday);
}

Calendar.prototype.write_weekend_string = function(vday) {
	var i;

	// Return special formatting for the weekend day.
	if (Calendar.isWeekend(vday))
		return (" BGCOLOR=\"" + weekendColor + "\"");

	return "";
}

Calendar.prototype.format_data = function(p_day) {
	// Supports any format consisting of 'DD/YY/YYYY/MM/MON/MONTH/DOW'
	var vData = this.gFormat;
	var vMonth = 1 + this.gMonth;
	vMonth = (vMonth.toString().length < 2) ? "0" + vMonth : vMonth;
	var vMon = Calendar.get_month(this.gMonth).substr(0,3).toUpperCase();
	var vFMon = Calendar.get_month(this.gMonth).toUpperCase();
	var vY4 = new String(this.gYear);
	var vY2 = new String(this.gYear.substr(2,2));
	var vDD = (p_day.toString().length < 2) ? "0" + p_day : p_day;
	var vDOW = Calendar.get_dow(new Date(vMonth + "/" + vDD + "/" + vY4).getDay());

	if ((new RegExp("YYYY", "ig")).test(vData))
		vData = vData.replace(/YYYY/ig, vY4);
	else if ((new RegExp("YY", "ig")).test(vData))
		vData = vData.replace(/YY/ig, vY2);
	if ((new RegExp("DD", "ig")).test(vData))
		vData = vData.replace(/DD/ig, vDD);
	if ((new RegExp("MM", "ig")).test(vData))
		vData = vData.replace(/MM/ig, vMonth);
	if ((new RegExp("MONTH", "ig")).test(vData))
		vData = vData.replace(/MONTH/ig, vFMon);
	else if ((new RegExp("MON", "ig")).test(vData))
		vData = vData.replace(/MON/ig, vMon);
	if ((new RegExp("DOW", "ig")).test(vData))
		vData = vData.replace(/DOW/ig, vDOW);

	return vData;
}

Calendar.prototype.format_dow = function(p_day) {
	var vData;
	var vMonth = 1 + this.gMonth;
	
	vMonth = (vMonth.toString().length < 2) ? "0" + vMonth : vMonth;
	var vMon = Calendar.get_month(this.gMonth).substr(0,3).toUpperCase();
	var vFMon = Calendar.get_month(this.gMonth).toUpperCase();
	var vY4 = new String(this.gYear);
	var vDD = (p_day.toString().length < 2) ? "0" + p_day : p_day;

	var vDate = new Date(vMonth + "\/" + vDD + "\/" + vY4);
	vData = Calendar.get_dow(vDate.getDay());
	
	return vData;
}

/*
Calendar Writing Functions
*/
Calendar.prototype.wwrite = function(wtext) {
	if (this.gType == "POPUP")
		this.gWinCal.document.writeln(wtext);
	else {
		// Keep adding to the codeINLINE variable.
		this.codeINLINE += wtext;
	}
}

Calendar.prototype.wwriteA = function(wtext) {
	if (this.gType == "POPUP")
		this.gWinCal.document.write(wtext);
	else {
		// Keep adding to the codeINLINE variable.
		this.codeINLINE += wtext;
	}
}

function Calendar_CreateCalendarLayer(pLeft, pTop, pInitText) {
	/* IMPORTANT : 
	If you use relative positioning of this layer, use LAYER Tag for Netscape.
	If you want absolute positioning, use DIV tag for Netscape.
	*/
	if (pInitText == null)
		pInitText = Calendar.gInitText;
	else
		Calendar.gInitText = pInitText;

	v_InlineX = pLeft;
	v_InlineY = pTop;

	var Calendar_ID = "Calendar";

	if (isIE)
		document.writeln("<DIV ID=\"" + Calendar_ID + "\" STYLE=\"" + 
		"position:absolute;zIndex:100;top:" + pTop + ";left:" + pLeft + ";" + 
		"\">" + pInitText + "<\/DIV>");
	else if (isDOM)
		document.writeln("<DIV ID=\"" + Calendar_ID + "\" STYLE=\"" + 
		"position:absolute;zIndex:100;top:" + pTop + ";left:" + pLeft + ";" + 
		"\">" + pInitText + "<\/DIV>");
	else if (isNav)
		document.writeln("<DIV ID=\"" + Calendar_ID + "\" STYLE=\"" + 
		"position:absolute;zIndex:100;top:" + pTop + ";left:" + pLeft + ";" + 
		"\">" + pInitText + "<\/DIV>");
}

function Calendar_Lwwrite(pText, pINLINE) {
	if (isIE) {
		document.all[pINLINE].innerHTML = pText;
	} else if (isDOM) {
		rng = document.createRange();
		el = document.getElementById(pINLINE);
		rng.setStartBefore(el);
		htmlFrag = rng.createContextualFragment(pText)
		while(el.hasChildNodes()) el.removeChild(el.lastChild);
		el.appendChild(htmlFrag);
	} else if (isNav) {
		var lyr = document.layers[pINLINE].document;
		lyr.open();
		lyr.write(pText);
		lyr.close();
	}
}

function Calendar_MoveTo(pX, pY, pINLINE) {
	if (isIE) {
		document.all[pINLINE].style.top = pY;
		document.all[pINLINE].style.left = pX;
	} else if (isDOM) {
		document.getElementById(pINLINE).style.top = pY;
		document.getElementById(pINLINE).style.left = pX;
	} else if (isNav) {
		document.layers[pINLINE].top = pY;
		document.layers[pINLINE].left = pX;
	}
}
/* ******************************************************************************* */
/*
Drag-n-Drop and Other Event-Handling Functions
*/
mDown = false;
mUp = false;

function fixCal(chkd) {
	if (chkd)
		initEvents(0);
	else
		initEvents(1);
}

function click(e) {
	x = (isIE) ? (event.x + document.body.scrollLeft) : e.pageX;
	y = (isIE) ? (event.y + document.body.scrollTop) : e.pageY;
	cx = (isIE) ? (x - parseInt(theCSSLayer.left)) : 
		((isDOM) ? (x - parseInt(theCSSLayer.left)) : (x - theLayer.x));
	cy = (isIE) ? (y - parseInt(theCSSLayer.top)) : 
		((isDOM) ? (y - parseInt(theCSSLayer.top)) : (y - theLayer.y));
	
	mUp = false;
	mDown = true;
}

function unclick(e) {
	mUp = true;
	mDown = false;
}

function handleMove(e) {
	currX = (isIE) ? (event.x + document.body.scrollLeft) : e.pageX;
	currY = (isIE) ? (event.y + document.body.scrollTop) : e.pageY;

	// If it is dragging, move the layer by the same shift..
	if (mDown) {
		window.status = "DRAGGGGGG : X=" + (currX-cx) + ", Y=" + (currY-cy);
		v_InlineX = currX - cx;
		v_InlineY = currY - cy;
		MoveLayer(currX - cx, currY - cy, "myLayer");
	} else
		window.status = "X=" + currX + ", Y=" + currY;
}

function initEvents(able) {
	if (able == 1) {
		if (isNav && !isDOM) {
			theLayer.captureEvents(Event.MOUSEDOWN | Event.MOUSEUP | Event.MOUSEMOVE);
		}

		if (isDOM && isNav) {
			theLayer.addEventListener("mousemove", handleMove, true);
			theLayer.addEventListener("mousedown", click, true);
			theLayer.addEventListener("mouseup", unclick, true);
		} else {
			// Assign handlers for mouse activity
			theLayer.onmousemove = handleMove;
			theLayer.onmousedown = click;
			theLayer.onmouseup = unclick;
		}
	} else {
		if (isNav && !isDOM) {
			theLayer.releaseEvents(Event.MOUSEDOWN | Event.MOUSEUP | Event.MOUSEMOVE);
		}

		if (isDOM && isNav) {
			theLayer.removeEventListener("mousemove", handleMove, true);
			theLayer.removeEventListener("mousedown", click, true);
			theLayer.removeEventListener("mouseup", unclick, true);
		} else {
			// Release handlers for mouse activity
			theLayer.onmousemove = "";
			theLayer.onmousedown = "";
			theLayer.onmouseup = "";
		}
	}
}

function MoveLayer(pX, pY) {
	theCSSLayer.top = pY;
	theCSSLayer.left = pX;
}

function drag_init(Leyer) {
	if (isIE) {
		theCSSLayer = document.all[Leyer].style;
		theLayer = document.all[Leyer];
	} else if (isDOM) {
		theCSSLayer = document.getElementById(Leyer).style;
		theLayer = document.getElementById(Leyer);
	} else if (isNav) {
		theCSSLayer = document.layers[Leyer];
		theLayer = document.layers[Leyer];
	}

	if (v_Fix == "Yes")
		initEvents(0);
	else
		initEvents(1);
}

function CalResize() {
	// Store these values 
	// so that subsequent calendar windows keep the same settings.
	v_Height = ggWinCal.innerHeight;
	v_Width = ggWinCal.innerWidth;
}

/* ******************************************************************************* */
/*
Calendar Build Function
*/
function Build(p_item, p_month, p_year, p_format, p_type, p_custom) {
	if (p_custom && p_custom != "") {
		// Reset the name/value variables 
		// which should not be carried forward to the next calendar..
		v_CurrentDate = "";

		// Read Custom parameters from the custom string here..
		var vvars = name_values(p_custom);
		var whois = "document." + p_item + ".value";
		//alert(whois);

		// If the return item has some date in it, 
		// take that as the starting date for the calendar.
		var returnItemValue = eval(whois);
		if (returnItemValue != "")
			v_CurrentDate = returnItemValue;

		v_Weekends = chkVar("v_Weekends") ? v_Weekends : "06";
		for (i=0; i<v_Weekends.length; i++)
			weekend.push(parseInt(v_Weekends.charAt(i)));
	} else
		v_CurrentDate = "";

	// If the current date is specified, 
	// split it & send it to the calendar...
	var vCurrentDate;
	if (chkVar("v_CurrentDate")) {
		if (Calendar.processDateData(v_CurrentDate, p_format) == null)
			vCurrentDate = new Date();
		else
			vCurrentDate = new Date(Calendar.processDateData(v_CurrentDate, p_format));
		p_month = vCurrentDate.getMonth();
		p_year = vCurrentDate.getFullYear().toString();
	} else
		vCurrentDate = "NONE";

	v_Resizable = chkVar("v_Resizable") ? v_Resizable : "No";
	
/*	v_SelectAfter = (typeof v_SelectAfter == "string") ? 
			new Date(Calendar.processDateData(v_SelectAfter, p_format)) :
			v_SelectAfter;
	v_SelectBefore = (typeof v_SelectBefore == "string") ?
			new Date(Calendar.processDateData(v_SelectBefore, p_format)) :
			v_SelectBefore;
*/

	v_SelectAfter = (typeof v_SelectAfter == "string") ? 
			new Date(1920,01,01) :
			v_SelectAfter;
	v_SelectBefore = (typeof v_SelectBefore == "string") ?
			new Date(2080,01,01) :
			v_SelectBefore;


	v_NSHierarchy = isNav ? 
					(chkVar("v_NSHierarchy") ? (v_NSHierarchy + ".document.") : "")
					: "";
	v_CallFunction = chkVar("v_CallFunction") ? v_CallFunction : "";
	v_Nav = chkVar("v_Nav") ? v_Nav : "Yes";
	v_SmartNav = chkVar("v_SmartNav") ? v_SmartNav : "No";
	v_Fix = chkVar("v_Fix") ? v_Fix : "Yes";
	v_WeekStart = chkVar("v_WeekStart") ? parseInt(v_WeekStart) : 0;

	var vHeight, vWidth;
	v_Width = chkVar("v_Width") ? v_Width : 220;
	v_Height = chkVar("v_Height") ? v_Height : 220;

	if (p_type == "POPUP") {
		vWidth = chkVar("v_Width") ? v_Width : 210;
		
		if (isIE) vHeight = chkVar("v_Height") ? v_Height : 210;
		else if (isNav) vHeight = chkVar("v_Height") ? v_Height : 230;
		if (v_SmartNav == "Yes")
			vHeight += 10;

		v_PopupX = chkVar("v_PopupX") ? v_PopupX : -1;
		v_PopupY = chkVar("v_PopupY") ? v_PopupY : -1;
		
		if (v_PopupX >= 0 && v_PopupY >= 0) {
			if (!ggWinCal || ggWinCal.closed)
				ggWinCal = window.open("", "Calendar", 
					"width=" + vWidth + ",height=" + vHeight + 
					",status=no,dependent=yes,resizable=" + v_Resizable +
					",screenX=" + v_PopupX + ",screenY=" + v_PopupY +
					",left=" + v_PopupX + ",top=" + v_PopupY);
		} else {
			if (!ggWinCal || ggWinCal.closed)
				ggWinCal = window.open("", "EMPLOYEE", 
					"width=" + vWidth + ",height=" + vHeight + 
					",status=no,dependent=yes,resizable=" + v_Resizable);
		}

		ggWinCal.opener = self;
		var p_WinCal = ggWinCal;

		if (isNav && !isDOM) {
			ggWinCal.captureEvents(Event.RESIZE);
		}
		ggWinCal.onResize = CalResize;
	}

	gCal = new Calendar(p_item, p_WinCal, p_month, p_year, p_format, p_type);

	gCal.gCurrentDate = vCurrentDate;
	v_CloseOnSelect = "Yes"
	gCal.gAllowWeekends = 
		(chkVar("v_AllowWeekends") && 
		v_AllowWeekends == "Yes") ? "Yes" : "No";

	gCal.closeable = chkVar("v_CloseOnSelect") ? 
		((v_CloseOnSelect == "Yes") ? true : false)
		: true;

	gCal.returnMode = chkVar("v_AppendOrReplace") ?
		v_AppendOrReplace : "Replace";

	gCal.returnData = chkVar("v_ReturnData") ?
		v_ReturnData : "Date";

	// Character to be added For Append mode
	gCal.appendChar = (gCal.returnMode == "Append") ?
		chkVar("v_AppendChar") ? v_AppendChar : ";" 
		: "";

	gCal.CallFunction = chkVar("v_CallFunction") ? v_CallFunction : "";

	// Position for INLINE Calendar
	// It either comes from the Calendar_CreateCalendarLayer function or 
	// from the InlinX, InlineY vars.
	gCal.InlineX = chkVar("v_InlineX") ? v_InlineX : 100;
	gCal.InlineY = chkVar("v_InlineY") ? v_InlineY : 100;

	// Re-position INLINE Calendar now
	if (gCal.gType == "INLINE") {
		Calendar.MoveTo(gCal.InlineX, gCal.InlineY, gCal.INLINE);
	}

	gCal.gTitle = v_Title ? v_Title : gCal.gMonthName + "/" + gCal.gYear;

	// ############ CUSTOMIZE #############
	// Customize your Calendar here..
	gCal.gBGColor="white";
	gCal.gLinkColor="black";
	gCal.gTextColor="black";
	gCal.gHeaderColor="darkgreen";
	// ############ CUSTOMIZE #############
	
	// Choose appropriate show function
	if (gCal.gYearly)	gCal.showY();
	else gCal.show();

	if (gCal.gType == "INLINE") {
		// Initialize INLINE Calendar for drag-n-drop functionality
		drag_init(gCal.INLINE);
	}
}

/* ******************************************************************************* */
function show_calendar() {
	/* 
		p_item  : Return Item.
		p_month : 0-11 for Jan-Dec; 12 for All Months.
		p_year  : 4-digit year
		p_format: Date format (mm/dd/yyyy, dd/mm/yy, ...)
		p_type	: POPUP/INLINE Calendar
		p_custom: String of customizable name/value pair parameters
					v_CloseOnSelect
					v_AppendOrReplace
					v_AppendChar
					v_ReturnData
					v_InlineX
					v_InlineY
					v_Title
					v_CurrentDate
					v_AllowWeekends
					v_Height
					v_Width
					v_Resizable
					v_SelectAfter
					v_NSHierarchy	: If the form calling calendar is in a layer
										(reqd only for Netscape)
					v_SelectBefore
					v_CallFunction	: Name of the void function to be called
										after the date is populated
										in the return item
					v_PopupX
					v_PopupY
					v_Nav		: Yes/No for Navigation bar
					v_SmartNav	: Yes/No for Smart Navigation bar
					v_Fix		: Yes/No for fixing the calendar by default
					v_WeekStart	: Starting day for the week (Sun, Mon, ..)
					v_Weekends	: Weekend days string. Ex 06 (Sun and Sat)
	*/

	p_item = arguments[0];
	if (!chkArg(arguments[1]))
		p_month = new String(gNow.getMonth());
	else
		p_month = (typeof(arguments[1]) == "number") ? 
						arguments[1].toString() 
						: 
						((arguments[1] == "") ? new String(gNow.getMonth()) : arguments[1]);
	if (!chkArg(arguments[2]))
		p_year = new String(gNow.getFullYear().toString());
	else
		p_year = (typeof(arguments[2]) == "number") ? 
						arguments[2].toString() 
						: 
						arguments[2];
	if (!chkArg(arguments[3]))
		p_format = "MM/DD/YYYY";
	else
		p_format = (typeof(arguments[3]) == "string") ? 
						arguments[3] 
						: 
						"MM/DD/YYYY";
	if (!chkArg(arguments[4]))
		p_type = "POPUP";
	else
		p_type = (typeof(arguments[4]) == "string" && 
					(arguments[4] == "POPUP" || arguments[4] == "INLINE")) ?
						arguments[4]
						:
						"POPUP";
	if (!chkArg(arguments[5]))
		p_custom = "AppendOrReplace=Replace;AppendChar=';';CloseOnSelect=Yes;ReturnData=Date;Title=EMPLOYEE;InlineX=400;InlineY=50;CurrentDate=today();SelectAfter=Today-20002;SelectBefore=Today+20002;AllowWeekends=Yes;Resizable=No;CallFunction=TryCallFunction;PopupX=300;PopupY=300;Nav=Yes;SmartNav=Yes;Fix=No;WeekStart=0;Weekends=06;"
	else
		p_custom = typeof(arguments[5]) == "string" ?
					arguments[5]
					:
					"AppendOrReplace=Replace;AppendChar=';';CloseOnSelect=Yes;ReturnData=Date;Title=EMPLOYEE;InlineX=400;InlineY=50;CurrentDate=today();SelectAfter=Today-20002;SelectBefore=Today+20002;AllowWeekends=Yes;Resizable=No;CallFunction=TryCallFunction;PopupX=300;PopupY=300;Nav=Yes;SmartNav=Yes;Fix=No;WeekStart=0;Weekends=06;"

	Build(p_item, p_month, p_year, p_format, p_type, p_custom);
}

function TryCallFunction()
{
}

/* ******************************************************************************* */
/*
Yearly Calendar Code Starts here
*/
function show_yearly_calendar(p_item, p_year, p_format) {
	// Load the defaults..
	if (p_year == null || p_year == "")
		p_year = new String(gNow.getFullYear().toString());
	else
		p_year = (typeof(p_year) == "number") ?
					p_year.toString()
					:
					p_year;

	if (p_format == null || p_format == "")
			p_format = "MM/DD/YYYY";

	var ggWinCal = window.open("", "Calendar", "scrollbars=yes");
	ggWinCal.opener = self;

	Build(p_item, null, p_year, p_format, "POPUP");
}
/* *********************************EOF********************************* */
