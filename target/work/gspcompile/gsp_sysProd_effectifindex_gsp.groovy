import application.RH.Effectif
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_effectifindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/effectif/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'effectif.label', default: 'Effectif'))],-1)
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
invokeTag('sortableColumn','g',27,['property':("username"),'title':(message(code: 'effectif.username.label', default: 'Username'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("password"),'title':(message(code: 'effectif.password.label', default: 'Password'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',31,['property':("mailEffectif"),'title':(message(code: 'effectif.mailEffectif.label', default: 'Mail Effectif'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',33,['property':("nom"),'title':(message(code: 'effectif.nom.label', default: 'Nom'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',35,['property':("prenom"),'title':(message(code: 'effectif.prenom.label', default: 'Prenom'))],-1)
printHtmlPart(14)
invokeTag('message','g',37,['code':("effectif.equipe.label"),'default':("Equipe")],-1)
printHtmlPart(15)
loop:{
int i = 0
for( effectifInstance in (effectifInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: effectifInstance, field: "username"))
})
invokeTag('link','g',45,['action':("show"),'id':(effectifInstance.id)],3)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: effectifInstance, field: "password"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: effectifInstance, field: "mailEffectif"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: effectifInstance, field: "nom"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: effectifInstance, field: "prenom"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: effectifInstance, field: "equipe"))
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('paginate','g',62,['total':(effectifInstanceCount ?: 0)],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043304L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
