import application.PP.Ordonnancement
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_ordonnancement_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ordonnancement/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: ordonnancementInstance, field: 'famille', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("ordonnancement.famille.label"),'default':("Famille")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("famille"),'name':("famille.id"),'from':(application.PP.Famille.list()),'optionKey':("id"),'value':(ordonnancementInstance?.famille?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: ordonnancementInstance, field: 'phases', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("ordonnancement.phases.label"),'default':("Phases")],-1)
printHtmlPart(5)
for( p in (ordonnancementInstance?.phases) ) {
printHtmlPart(6)
createTagBody(2, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',22,['controller':("phase"),'action':("show"),'id':(p.id)],2)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'phase.label', default: 'Phase')]))
})
invokeTag('link','g',25,['controller':("phase"),'action':("create"),'params':(['ordonnancement.id': ordonnancementInstance?.id])],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: ordonnancementInstance, field: 'chargeStandard', 'error'))
printHtmlPart(10)
invokeTag('message','g',34,['code':("ordonnancement.chargeStandard.label"),'default':("Charge Standard")],-1)
printHtmlPart(11)
invokeTag('field','g',37,['name':("chargeStandard"),'value':(fieldValue(bean: ordonnancementInstance, field: 'chargeStandard')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: ordonnancementInstance, field: 'nom', 'error'))
printHtmlPart(12)
invokeTag('message','g',43,['code':("ordonnancement.nom.label"),'default':("Nom")],-1)
printHtmlPart(2)
invokeTag('textField','g',46,['name':("nom"),'value':(ordonnancementInstance?.nom)],-1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043419L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
