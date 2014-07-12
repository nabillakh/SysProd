import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_mailEffectifshow2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailEffectif/show2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'mail.label', default: 'Mail'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',9,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(5)
invokeTag('message','g',12,['code':("default.home.label")],-1)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',13,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',13,['class':("list"),'action':("index")],2)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',18,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (mailEffectifInstance.mail?.author)) {
printHtmlPart(13)
invokeTag('message','g',26,['code':("maileffectif.mail.author.label"),'default':("Author")],-1)
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(mailEffectifInstance.mail?.author?.encodeAsHTML())
})
invokeTag('link','g',28,['controller':("effectif"),'action':("show"),'id':(mailEffectifInstance.mail?.author?.id)],3)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (mailEffectifInstance?.mail.objet)) {
printHtmlPart(17)
invokeTag('message','g',35,['code':(".mailEffectif.mail.objet"),'default':("objet")],-1)
printHtmlPart(18)
expressionOut.print(mailEffectifInstance.mail.objet)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (mailEffectifInstance?.lu)) {
printHtmlPart(19)
invokeTag('message','g',44,['code':("mailEffectif.lu.label"),'default':("Lu")],-1)
printHtmlPart(20)
invokeTag('formatBoolean','g',46,['boolean':(mailEffectifInstance?.lu)],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (mailEffectifInstance.mail.message)) {
printHtmlPart(21)
invokeTag('message','g',53,['code':("mailEffectif.mail.message.label"),'default':("Message")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',55,['bean':(mailEffectifInstance.mail),'field':("message")],-1)
printHtmlPart(15)
}
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',65,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',65,['class':("edit"),'action':("edit"),'resource':(mailInstance)],3)
printHtmlPart(25)
invokeTag('actionSubmit','g',66,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(26)
})
invokeTag('form','g',68,['url':([resource:mailInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043408L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
