import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_kanbangestionOf_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/gestionOf.gsp" }
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
createClosureForHtmlPart(42, 2)
invokeTag('link','g',105,['action':("index"),'controller':("kanban")],2)
printHtmlPart(43)
createClosureForHtmlPart(44, 2)
invokeTag('link','g',106,['action':("show"),'controller':("kanban"),'id':(kanbanInstance.id)],2)
printHtmlPart(45)
loop:{
int i = 0
for( mesofInstance in (mesof) ) {
printHtmlPart(46)
invokeTag('set','g',112,['var':("of"),'value':(mesofInstance.id)],-1)
printHtmlPart(47)
loop:{
int j = 0
for( dateLIstInstance in (dateLIst) ) {
printHtmlPart(47)
invokeTag('set','g',114,['var':("laof"),'value':(dateLIstInstance.id)],-1)
printHtmlPart(48)
if(true && (laof == of)) {
printHtmlPart(49)
invokeTag('set','g',116,['var':("deb"),'value':(dateLIstInstance.start)],-1)
printHtmlPart(50)
invokeTag('set','g',117,['var':("fin"),'value':(dateLIstInstance.end)],-1)
printHtmlPart(51)
}
printHtmlPart(52)
j++
}
}
printHtmlPart(53)
expressionOut.print(mesofInstance?.phase?.nom)
printHtmlPart(54)
if(true && (flash.message)) {
printHtmlPart(55)
expressionOut.print(flash.message)
printHtmlPart(56)
}
printHtmlPart(57)
createTagBody(3, {->
printHtmlPart(58)
expressionOut.print(i)
printHtmlPart(59)
expressionOut.print(mesofInstance?.id)
printHtmlPart(60)
invokeTag('message','g',143,['code':("OF.chargePlanifiee.label"),'default':("Charge Planifiee")],-1)
printHtmlPart(61)
invokeTag('field','g',146,['name':("chargePlanifiee"),'id':("chargeplanifiee${i}"),'value':(fieldValue(bean: mesofInstance, field: 'chargePlanifiee'))],-1)
printHtmlPart(62)
invokeTag('message','g',152,['code':("OF.affectes.label"),'default':("Affectes")],-1)
printHtmlPart(63)
invokeTag('select','g',155,['id':("affectes${i}"),'multiple':("multiple"),'name':("affectes"),'from':(application.RH.Effectif.list()),'optionKey':("id"),'required':(""),'value':(mesofInstance?.affectes*.id),'class':("span12 with-search")],-1)
printHtmlPart(64)
expressionOut.print(fin)
printHtmlPart(65)
expressionOut.print(i)
printHtmlPart(59)
expressionOut.print(deb)
printHtmlPart(66)
expressionOut.print(fin)
printHtmlPart(67)
expressionOut.print(fin)
printHtmlPart(68)
expressionOut.print(i)
printHtmlPart(69)
expressionOut.print(i)
printHtmlPart(70)
})
invokeTag('form','g',197,['url':([action:'majOF'])],3)
printHtmlPart(71)
i++
}
}
printHtmlPart(72)
invokeTag('remoteFunction','g',219,['controller':("kanban"),'action':("majOF"),'params':("\'monId=\' + id+ '&charge=\' + charge+ '&dateFinPlanifie=\' + dateFinPlanifie+ '&dateDebutPlanifie=\' + dateDebutPlanifie+ '&affectes=\' + affectes")],-1)
printHtmlPart(73)
invokeTag('render','g',233,['template':("/menues/mainright")],-1)
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
expressionOut.print(request.contextPath)
printHtmlPart(111)
expressionOut.print(request.contextPath)
printHtmlPart(112)
expressionOut.print(request.contextPath)
printHtmlPart(113)
expressionOut.print(request.contextPath)
printHtmlPart(114)
expressionOut.print(request.contextPath)
printHtmlPart(115)
expressionOut.print(request.contextPath)
printHtmlPart(116)
expressionOut.print(request.contextPath)
printHtmlPart(117)
expressionOut.print(request.contextPath)
printHtmlPart(118)
expressionOut.print(request.contextPath)
printHtmlPart(119)
expressionOut.print(request.contextPath)
printHtmlPart(120)
expressionOut.print(request.contextPath)
printHtmlPart(121)
expressionOut.print(request.contextPath)
printHtmlPart(122)
expressionOut.print(request.contextPath)
printHtmlPart(123)
expressionOut.print(request.contextPath)
printHtmlPart(124)
expressionOut.print(request.contextPath)
printHtmlPart(125)
expressionOut.print(request.contextPath)
printHtmlPart(126)
expressionOut.print(request.contextPath)
printHtmlPart(127)
expressionOut.print(request.contextPath)
printHtmlPart(128)
})
invokeTag('captureBody','sitemesh',378,[:],1)
printHtmlPart(129)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043374L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
