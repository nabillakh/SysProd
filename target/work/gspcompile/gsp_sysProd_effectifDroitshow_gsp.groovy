import application.RH.EffectifDroit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_effectifDroitshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/effectifDroit/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'effectifDroit.label', default: 'EffectifDroit'))],-1)
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
if(true && (effectifDroitInstance?.droit)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("effectifDroit.droit.label"),'default':("Droit")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(effectifDroitInstance?.droit?.encodeAsHTML())
})
invokeTag('link','g',30,['controller':("droit"),'action':("show"),'id':(effectifDroitInstance?.droit?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (effectifDroitInstance?.effectif)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("effectifDroit.effectif.label"),'default':("Effectif")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(effectifDroitInstance?.effectif?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("effectif"),'action':("show"),'id':(effectifDroitInstance?.effectif?.id)],3)
printHtmlPart(16)
}
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createTagBody(3, {->
invokeTag('message','g',47,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',47,['class':("edit"),'action':("edit"),'resource':(effectifDroitInstance)],3)
printHtmlPart(22)
invokeTag('actionSubmit','g',48,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(23)
})
invokeTag('form','g',50,['url':([resource:effectifDroitInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',52,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043314L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
