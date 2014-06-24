import application.RH.Equipe
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_equipe_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/equipe/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: equipeInstance, field: 'mesEffectifs', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("equipe.mesEffectifs.label"),'default':("Mes Effectifs")],-1)
printHtmlPart(2)
for( m in (equipeInstance?.mesEffectifs) ) {
printHtmlPart(3)
createTagBody(2, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',13,['controller':("effectif"),'action':("show"),'id':(m.id)],2)
printHtmlPart(4)
}
printHtmlPart(5)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'effectif.label', default: 'Effectif')]))
})
invokeTag('link','g',16,['controller':("effectif"),'action':("create"),'params':(['equipe.id': equipeInstance?.id])],1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: equipeInstance, field: 'nom', 'error'))
printHtmlPart(7)
invokeTag('message','g',25,['code':("equipe.nom.label"),'default':("Nom")],-1)
printHtmlPart(8)
invokeTag('textField','g',28,['name':("nom"),'value':(equipeInstance?.nom)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043315L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
