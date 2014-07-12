import application.RH.EffectifDroit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_effectifDroit_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/effectifDroit/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: effectifDroitInstance, field: 'droit', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("effectifDroit.droit.label"),'default':("Droit")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("droit"),'name':("droit.id"),'from':(application.RH.Droit.list()),'optionKey':("id"),'required':(""),'value':(effectifDroitInstance?.droit?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: effectifDroitInstance, field: 'effectif', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("effectifDroit.effectif.label"),'default':("Effectif")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("effectif"),'name':("effectif.id"),'from':(application.RH.Effectif.list()),'optionKey':("id"),'required':(""),'value':(effectifDroitInstance?.effectif?.id),'class':("many-to-one")],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043310L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
