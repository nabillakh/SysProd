import application.communication.EventEffectif
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_eventEffectifindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/eventEffectif/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'eventEffectif.label', default: 'EventEffectif'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',27,['property':("dateCreation"),'title':(message(code: 'eventEffectif.dateCreation.label', default: 'Date Creation'))],-1)
printHtmlPart(13)
invokeTag('message','g',29,['code':("eventEffectif.event.label"),'default':("Event")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("participe"),'title':(message(code: 'eventEffectif.participe.label', default: 'Participe'))],-1)
printHtmlPart(13)
invokeTag('message','g',33,['code':("eventEffectif.recepteur.label"),'default':("Recepteur")],-1)
printHtmlPart(15)
loop:{
int i = 0
for( eventEffectifInstance in (eventEffectifInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: eventEffectifInstance, field: "dateCreation"))
})
invokeTag('link','g',41,['action':("show"),'id':(eventEffectifInstance.id)],3)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: eventEffectifInstance, field: "event"))
printHtmlPart(18)
invokeTag('formatBoolean','g',45,['boolean':(eventEffectifInstance.participe)],-1)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: eventEffectifInstance, field: "recepteur"))
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('paginate','g',54,['total':(eventEffectifInstanceCount ?: 0)],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',57,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043345L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
