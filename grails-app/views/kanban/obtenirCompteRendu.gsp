

<table  class="table table-bordered responsive table-hover" id="col-filter">
      <thead>
        <tr>
          <th><center>Date</center></th>
          <th><center>Auteur</center></th>
          <th colspan="2"><center>Message</center></th>
        </tr>
      </thead>
      <tbody>
  
<g:each in="${mesCR}" var="compteRenduMessage">
<div>
  <tr>
    <td><center> <g:formatDate format="dd-MM-yyyy" date="${compteRenduMessage.dateCreated}"/> </center> </td>
    <td> <center><strong><span class="author">${compteRenduMessage.author.prenom} ${compteRenduMessage.author.nom}</span>  </strong></center></td>
    <td colspan="2"><center> <span class="statutMessage">${compteRenduMessage.message}</span></center></td>
    </tr>
</div>
  </g:each></tbody>
  </table>