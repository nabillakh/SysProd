import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_picindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pic/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("HandheldFriendly"),'content':("True")],-1)
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("MobileOptimized"),'content':("320")],-1)
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',16,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no")],-1)
printHtmlPart(6)
expressionOut.print(request.contextPath)
printHtmlPart(7)
expressionOut.print(request.contextPath)
printHtmlPart(8)
expressionOut.print(request.contextPath)
printHtmlPart(9)
expressionOut.print(request.contextPath)
printHtmlPart(10)
expressionOut.print(request.contextPath)
printHtmlPart(11)
expressionOut.print(request.contextPath)
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(13)
expressionOut.print(request.contextPath)
printHtmlPart(14)
expressionOut.print(request.contextPath)
printHtmlPart(15)
expressionOut.print(request.contextPath)
printHtmlPart(16)
expressionOut.print(request.contextPath)
printHtmlPart(17)
expressionOut.print(request.contextPath)
printHtmlPart(18)
expressionOut.print(request.contextPath)
printHtmlPart(19)
expressionOut.print(request.contextPath)
printHtmlPart(20)
expressionOut.print(request.contextPath)
printHtmlPart(21)
expressionOut.print(request.contextPath)
printHtmlPart(22)
expressionOut.print(request.contextPath)
printHtmlPart(23)
expressionOut.print(request.contextPath)
printHtmlPart(24)
expressionOut.print(request.contextPath)
printHtmlPart(25)
expressionOut.print(request.contextPath)
printHtmlPart(26)
expressionOut.print(request.contextPath)
printHtmlPart(27)
expressionOut.print(request.contextPath)
printHtmlPart(28)
expressionOut.print(request.contextPath)
printHtmlPart(29)
expressionOut.print(request.contextPath)
printHtmlPart(30)
expressionOut.print(request.contextPath)
printHtmlPart(31)
expressionOut.print(request.contextPath)
printHtmlPart(32)
expressionOut.print(request.contextPath)
printHtmlPart(33)
invokeTag('captureMeta','sitemesh',81,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-capable"),'content':("yes")],-1)
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',82,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-status-bar-style"),'content':("black")],-1)
printHtmlPart(34)
invokeTag('captureMeta','sitemesh',84,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-title"),'content':("Sysprod")],-1)
printHtmlPart(35)
expressionOut.print(request.contextPath)
printHtmlPart(36)
expressionOut.print(request.contextPath)
printHtmlPart(37)
expressionOut.print(request.contextPath)
printHtmlPart(38)
})
invokeTag('captureHead','sitemesh',91,[:],1)
printHtmlPart(39)
createTagBody(1, {->
printHtmlPart(40)
invokeTag('render','g',95,['template':("/menues/mainleft")],-1)
printHtmlPart(41)
expressionOut.print(year-1)
printHtmlPart(42)
expressionOut.print(year)
printHtmlPart(42)
expressionOut.print(year+1)
printHtmlPart(42)
expressionOut.print(year+2)
printHtmlPart(43)
loop:{
int j = 0
for( fam in (mesFamilles) ) {
printHtmlPart(44)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: fam, field: "nom"))
})
invokeTag('link','g',138,['action':("show"),'controller':("Famille"),'id':(fam.id)],3)
printHtmlPart(45)
loop:{
int k = 0
for( ordo in (fam.ordo) ) {
printHtmlPart(46)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: ordo, field: "nom"))
printHtmlPart(47)
})
invokeTag('link','g',146,['action':("show"),'controller':("Ordonnancement"),'id':(ordo.id)],4)
printHtmlPart(48)
loop:{
int p = 0
for( pf in (pic1.picFamille) ) {
printHtmlPart(49)
if(true && (pf.ordo == ordo)) {
printHtmlPart(50)
expressionOut.print(pf.uniteActivite)
printHtmlPart(49)
}
printHtmlPart(49)
p++
}
}
printHtmlPart(51)
loop:{
int p = 0
for( pf in (pic2.picFamille) ) {
printHtmlPart(49)
if(true && (pf.ordo == ordo)) {
printHtmlPart(50)
expressionOut.print(pf.uniteActivite)
printHtmlPart(49)
}
printHtmlPart(49)
p++
}
}
printHtmlPart(48)
loop:{
int p = 0
for( pf in (pic3.picFamille) ) {
printHtmlPart(49)
if(true && (pf.ordo == ordo)) {
printHtmlPart(50)
expressionOut.print(pf.uniteActivite)
printHtmlPart(49)
}
printHtmlPart(49)
p++
}
}
printHtmlPart(48)
loop:{
int p = 0
for( pf in (pic4.picFamille) ) {
printHtmlPart(49)
if(true && (pf.ordo == ordo)) {
printHtmlPart(50)
expressionOut.print(pf.uniteActivite)
printHtmlPart(49)
}
printHtmlPart(49)
p++
}
}
printHtmlPart(52)
k++
}
}
printHtmlPart(49)
j++
}
}
printHtmlPart(53)
createClosureForHtmlPart(54, 2)
invokeTag('mesPics','pic',192,[:],2)
printHtmlPart(55)
invokeTag('render','g',210,['template':("/menues/mainright")],-1)
printHtmlPart(56)
expressionOut.print(request.contextPath)
printHtmlPart(57)
expressionOut.print(request.contextPath)
printHtmlPart(58)
expressionOut.print(request.contextPath)
printHtmlPart(59)
expressionOut.print(request.contextPath)
printHtmlPart(60)
expressionOut.print(request.contextPath)
printHtmlPart(61)
expressionOut.print(request.contextPath)
printHtmlPart(62)
expressionOut.print(request.contextPath)
printHtmlPart(63)
expressionOut.print(request.contextPath)
printHtmlPart(64)
expressionOut.print(request.contextPath)
printHtmlPart(65)
expressionOut.print(request.contextPath)
printHtmlPart(66)
expressionOut.print(request.contextPath)
printHtmlPart(67)
expressionOut.print(request.contextPath)
printHtmlPart(68)
expressionOut.print(request.contextPath)
printHtmlPart(69)
expressionOut.print(request.contextPath)
printHtmlPart(70)
expressionOut.print(request.contextPath)
printHtmlPart(71)
expressionOut.print(request.contextPath)
printHtmlPart(72)
expressionOut.print(request.contextPath)
printHtmlPart(73)
expressionOut.print(request.contextPath)
printHtmlPart(74)
expressionOut.print(request.contextPath)
printHtmlPart(75)
expressionOut.print(request.contextPath)
printHtmlPart(76)
expressionOut.print(request.contextPath)
printHtmlPart(77)
expressionOut.print(request.contextPath)
printHtmlPart(78)
expressionOut.print(request.contextPath)
printHtmlPart(79)
expressionOut.print(request.contextPath)
printHtmlPart(80)
expressionOut.print(request.contextPath)
printHtmlPart(81)
expressionOut.print(request.contextPath)
printHtmlPart(82)
expressionOut.print(request.contextPath)
printHtmlPart(83)
expressionOut.print(request.contextPath)
printHtmlPart(84)
expressionOut.print(request.contextPath)
printHtmlPart(85)
expressionOut.print(request.contextPath)
printHtmlPart(86)
expressionOut.print(request.contextPath)
printHtmlPart(87)
expressionOut.print(request.contextPath)
printHtmlPart(88)
expressionOut.print(request.contextPath)
printHtmlPart(89)
expressionOut.print(request.contextPath)
printHtmlPart(90)
expressionOut.print(request.contextPath)
printHtmlPart(91)
expressionOut.print(request.contextPath)
printHtmlPart(92)
expressionOut.print(request.contextPath)
printHtmlPart(93)
expressionOut.print(request.contextPath)
printHtmlPart(94)
expressionOut.print(request.contextPath)
printHtmlPart(95)
expressionOut.print(request.contextPath)
printHtmlPart(96)
expressionOut.print(request.contextPath)
printHtmlPart(97)
expressionOut.print(request.contextPath)
printHtmlPart(98)
expressionOut.print(request.contextPath)
printHtmlPart(99)
expressionOut.print(request.contextPath)
printHtmlPart(100)
expressionOut.print(request.contextPath)
printHtmlPart(101)
expressionOut.print(request.contextPath)
printHtmlPart(102)
expressionOut.print(request.contextPath)
printHtmlPart(103)
expressionOut.print(request.contextPath)
printHtmlPart(104)
expressionOut.print(request.contextPath)
printHtmlPart(105)
expressionOut.print(request.contextPath)
printHtmlPart(106)
expressionOut.print(request.contextPath)
printHtmlPart(107)
expressionOut.print(request.contextPath)
printHtmlPart(108)
expressionOut.print(request.contextPath)
printHtmlPart(109)
expressionOut.print(request.contextPath)
printHtmlPart(110)
})
invokeTag('captureBody','sitemesh',355,[:],1)
printHtmlPart(111)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043449L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
