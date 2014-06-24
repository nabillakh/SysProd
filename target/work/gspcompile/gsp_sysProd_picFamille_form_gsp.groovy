import application.pilotage.PicFamille
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_picFamille_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/picFamille/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: picFamilleInstance, field: 'dateVersion', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("picFamille.dateVersion.label"),'default':("Date Version")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("dateVersion"),'precision':("day"),'value':(picFamilleInstance?.dateVersion),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: picFamilleInstance, field: 'dateMaj', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("picFamille.dateMaj.label"),'default':("Date Maj")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',19,['name':("dateMaj"),'precision':("day"),'value':(picFamilleInstance?.dateMaj),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: picFamilleInstance, field: 'ordo', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("picFamille.ordo.label"),'default':("Ordo")],-1)
printHtmlPart(6)
invokeTag('select','g',28,['id':("ordo"),'name':("ordo.id"),'from':(application.PP.Ordonnancement.list()),'optionKey':("id"),'required':(""),'value':(picFamilleInstance?.ordo?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: picFamilleInstance, field: 'pdp', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("picFamille.pdp.label"),'default':("Pdp")],-1)
printHtmlPart(8)
for( p in (picFamilleInstance?.pdp) ) {
printHtmlPart(9)
createTagBody(2, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',40,['controller':("pdp"),'action':("show"),'id':(p.id)],2)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'pdp.label', default: 'Pdp')]))
})
invokeTag('link','g',43,['controller':("pdp"),'action':("create"),'params':(['picFamille.id': picFamilleInstance?.id])],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: picFamilleInstance, field: 'uniteActivite', 'error'))
printHtmlPart(13)
invokeTag('message','g',52,['code':("picFamille.uniteActivite.label"),'default':("Unite Activite")],-1)
printHtmlPart(6)
invokeTag('field','g',55,['name':("uniteActivite"),'value':(fieldValue(bean: picFamilleInstance, field: 'uniteActivite')),'required':("")],-1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043452L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
