<#include "security.ftl">
<#macro createGradeBook>
    <div id="createGradeBookId" class="modal">
        <form id="createGradebookFormId" class="modal-content animate" <#--action="/" method="post"-->>
            <div class="imgcontainer">
                <span onclick="document.getElementById('createGradeBookId').style.display='none'" class="close" title="Close Modal">&times;</span>
                <img src="https://image.freepik.com/free-vector/modern-education-concept-with-flat-design_23-2147919753.jpg"
                     alt="Avatar" class="avatar">
            </div>

            <div class="container">
                <label><b>Class Number</b></label>
                <#-- name="username" because of @Override public String getUsername() { return login;}-->
                <input type="text" placeholder="6" name="classNumber" value="6" required>
                <label><b>Class Letter</b></label>
                <input type="text" placeholder="A" name="classLetter" value="A" required>
                <label><b>Name of Subject</b></label>
                <input type="text" placeholder="Physics" name="subject" value="Physics" required>
                <input  type="hidden" name="user" value="${currentUserId}">
                <input  type="hidden" name="_csrf" value="${_csrf.token}">
              <#--  <button type="submit" class="btn-login" onclick="createGradebook()">Create</button>-->
                <input type="button" class="btn-login" onclick="createGradebook()" value="Create">
            </div>
            <div class="container" style="background-color:#f1f1f1">
                <button type="button" id="cancelBtn"  class="cancelbtn fa fa-close"
                        onclick="document.getElementById('createGradeBookId').style.display='none'"> Cancel</button>
            </div>
        </form>
    </div>

</#macro>