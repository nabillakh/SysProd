import application.PP.Famille
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_famille_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/famille/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: familleInstance, field: 'ordo', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("famille.ordo.label"),'default':("Ordo")],-1)
printHtmlPart(2)
for( o in (familleInstance?.ordo) ) {
printHtmlPart(3)
createTagBody(2, {->
expressionOut.print(o?.encodeAsHTML())
})
invokeTag('link','g',13,['controller':("ordonnancement"),'action':("show"),'id':(o.id)],2)
printHtmlPart(4)
}
printHtmlPart(5)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'ordonnancement.label', default: 'Ordonnancement')]))
})
invokeTag('link','g',16,['controller':("ordonnancement"),'action':("create"),'params':(['famille.id': familleInstance?.id])],1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: familleInstance, field: 'nom', 'error'))
printHtmlPart(7)
invokeTag('message','g',25,['code':("famille.nom.label"),'default':("Nom")],-1)
printHtmlPart(8)
invokeTag('textField','g',28,['name':("nom"),'value':(familleInstance?.nom)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043347L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
