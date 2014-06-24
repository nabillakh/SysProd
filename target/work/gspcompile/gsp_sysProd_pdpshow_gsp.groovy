import application.pilotage.Pdp
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_pdpshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pdp/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'pdp.label', default: 'Pdp'))],-1)
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
if(true && (pdpInstance?.dateVersion)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("pdp.dateVersion.label"),'default':("Date Version")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',30,['date':(pdpInstance?.dateVersion)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (pdpInstance?.dateMaj)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("pdp.dateMaj.label"),'default':("Date Maj")],-1)
printHtmlPart(19)
invokeTag('formatDate','g',39,['date':(pdpInstance?.dateMaj)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (pdpInstance?.uniteActivite)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("pdp.uniteActivite.label"),'default':("Unite Activite")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(pdpInstance),'field':("uniteActivite")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (pdpInstance?.kanbansRealises)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("pdp.kanbansRealises.label"),'default':("Kanbans Realises")],-1)
printHtmlPart(23)
for( k in (pdpInstance.kanbansRealises) ) {
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("pdpKanban"),'action':("show"),'id':(k.id)],4)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(17)
if(true && (pdpInstance?.mois)) {
printHtmlPart(27)
invokeTag('message','g',66,['code':("pdp.mois.label"),'default':("Mois")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',68,['bean':(pdpInstance),'field':("mois")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (pdpInstance?.picFamille)) {
printHtmlPart(29)
invokeTag('message','g',75,['code':("pdp.picFamille.label"),'default':("Pic Famille")],-1)
printHtmlPart(30)
createTagBody(3, {->
expressionOut.print(pdpInstance?.picFamille?.encodeAsHTML())
})
invokeTag('link','g',77,['controller':("picFamille"),'action':("show"),'id':(pdpInstance?.picFamille?.id)],3)
printHtmlPart(16)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',85,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',85,['class':("edit"),'action':("edit"),'resource':(pdpInstance)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',86,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',88,['url':([resource:pdpInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',90,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043428L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
