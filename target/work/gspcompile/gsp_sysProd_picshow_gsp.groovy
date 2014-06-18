import application.pilotage.Pic
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_picshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pic/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'pic.label', default: 'Pic'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (picInstance?.dateVersion)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("pic.dateVersion.label"),'default':("Date Version")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',30,['date':(picInstance?.dateVersion)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (picInstance?.dateMaj)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("pic.dateMaj.label"),'default':("Date Maj")],-1)
printHtmlPart(19)
invokeTag('formatDate','g',39,['date':(picInstance?.dateMaj)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (picInstance?.annee)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("pic.annee.label"),'default':("Annee")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(picInstance),'field':("annee")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (picInstance?.picFamille)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("pic.picFamille.label"),'default':("Pic Famille")],-1)
printHtmlPart(23)
for( p in (picInstance.picFamille) ) {
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("picFamille"),'action':("show"),'id':(p.id)],4)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',67,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',67,['class':("edit"),'action':("edit"),'resource':(picInstance)],3)
printHtmlPart(29)
invokeTag('actionSubmit','g',68,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(30)
})
invokeTag('form','g',70,['url':([resource:picInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043450L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
