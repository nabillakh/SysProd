import application.RH.Competence
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_competence_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/competence/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: competenceInstance, field: 'effectifs', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("competence.effectifs.label"),'default':("Effectifs")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['name':("effectifs"),'from':(application.RH.Effectif.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(competenceInstance?.effectifs*.id),'class':("many-to-many")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: competenceInstance, field: 'nom', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("competence.nom.label"),'default':("Nom")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("nom"),'value':(competenceInstance?.nom)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043281L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
