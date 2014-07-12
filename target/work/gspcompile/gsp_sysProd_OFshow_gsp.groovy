import application.PP.OF
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_OFshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/OF/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'OF.label', default: 'OF'))],-1)
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
if(true && (OFInstance?.chargePlanifiee)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("OF.chargePlanifiee.label"),'default':("Charge Planifiee")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(OFInstance),'field':("chargePlanifiee")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (OFInstance?.affectes)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("OF.affectes.label"),'default':("Affectes")],-1)
printHtmlPart(19)
for( a in (OFInstance.affectes) ) {
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(a?.encodeAsHTML())
})
invokeTag('link','g',40,['controller':("effectif"),'action':("show"),'id':(a.id)],4)
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(17)
if(true && (OFInstance?.dateDebutPlanifie)) {
printHtmlPart(23)
invokeTag('message','g',48,['code':("OF.dateDebutPlanifie.label"),'default':("Date Debut Planifie")],-1)
printHtmlPart(24)
invokeTag('formatDate','g',50,['date':(OFInstance?.dateDebutPlanifie)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (OFInstance?.dateFinPlanifie)) {
printHtmlPart(25)
invokeTag('message','g',57,['code':("OF.dateFinPlanifie.label"),'default':("Date Fin Planifie")],-1)
printHtmlPart(26)
invokeTag('formatDate','g',59,['date':(OFInstance?.dateFinPlanifie)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (OFInstance?.kanban)) {
printHtmlPart(27)
invokeTag('message','g',66,['code':("OF.kanban.label"),'default':("Kanban")],-1)
printHtmlPart(28)
createTagBody(3, {->
expressionOut.print(OFInstance?.kanban?.encodeAsHTML())
})
invokeTag('link','g',68,['controller':("kanban"),'action':("show"),'id':(OFInstance?.kanban?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (OFInstance?.phase)) {
printHtmlPart(29)
invokeTag('message','g',75,['code':("OF.phase.label"),'default':("Phase")],-1)
printHtmlPart(30)
createTagBody(3, {->
expressionOut.print(OFInstance?.phase?.encodeAsHTML())
})
invokeTag('link','g',77,['controller':("phase"),'action':("show"),'id':(OFInstance?.phase?.id)],3)
printHtmlPart(16)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',85,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',85,['class':("edit"),'action':("edit"),'resource':(OFInstance)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',86,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',88,['url':([resource:OFInstance, action:'delete']),'method':("DELETE")],2)
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
public static final long LAST_MODIFIED = 1401189043267L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
