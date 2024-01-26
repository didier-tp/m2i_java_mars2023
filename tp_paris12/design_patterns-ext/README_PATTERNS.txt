Decorateur: sur tp.caddy et 
                tp.test.CaddyDecoTestApp
            src/main/resources/caddyDeco.png 
            
Observateur : sur tp.dessin.observateur.*                                           
                et ongletObservateur de tp.dessin.app.v1.FenetrePrincipale
                
                
Visitor : sur tp.dessin.fig.AbstractFigVisitor 
              tp.dessin.fig.Figure.performVisit() , .Ligne.performVisit() , ...              
          sur tp.dessin.ext.swing.SwingDrawingVisitor
              tp.dessin.ext.svg.SvgDrawingVisitor
          sur tp.dessin.app.v1.OngletDessin.exporterSvg()
                                           .panneauBas_mouseReleased()
                                           
Command: sur tp.dessin.app.variante.command.FigCommand , AbstractFigCommand, ...
         et  tp.dessin.app.v2.OngletDessinV2
                                   .commandStack
                                   .redoCommandStack
                                   .panneauBas_mouseReleased()
                                   .btnEffacer_actionPerformed()
                                   ...
 
Prototype: sur tp.dessin.app.v2.OngletDessinV2
                                    .prototypesFigures
                                    .panneauBas_mousePressed()
                                                                                   
Chain of responsability : sur tp.basic.link.acl

Iterator: sur tp.basic.collection et tp.basic.MyIteratorTestApp
                                                                                   