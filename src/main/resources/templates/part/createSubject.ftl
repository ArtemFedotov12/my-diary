<#include "security.ftl">

<#macro createSubject>

    <div id="createSubjectId" class="modal">
        <form id="createSubjectFormId" class="modal-content animate">
            <div class="imgcontainer">
                <span onclick="document.getElementById('createSubjectId').style.display='none'" class="close" title="Close Modal">&times;</span>
                <img src="http://www.upsctoday.com/wp-content/uploads/2018/04/Optional-Subjects.jpg"
                     alt="Avatar" class="avatar-create-subject">
            </div>

            <div class="container">

                <div class="valid-feedback" id="subjectCreateSuccessId" style="display: block; opacity: 0">
                    Subject was created
                </div>



                <div>
                    <div class="invalid-feedback" id="nameOfSubjectLabelCreateSubjectId" style="display: none">
                        <#--Error Message-->
                    </div>
                    <label><b>Name of Subject</b></label>
                    <input type="text" id="nameOfSubjectCreateSubjectId" class="create-class form-control" placeholder="Physics" name="nameOfSubject" value="Physics" required>
                </div>

                <input  type="hidden" name="user" value="${currentUserId}">
                <input  type="hidden" name="_csrf" value="${_csrf.token}">
                <#--  <button type="submit" class="btn-login" onclick="createGradebook()">Create</button>-->
                <input type="button" class="btn-login" onclick="createSubject()" value="Create">
            </div>
            <div class="container" style="background-color:#f1f1f1">
                <button type="button" id="cancelBtn"  class="cancelbtn fa fa-close"
                        onclick="document.getElementById('createSubjectId').style.display='none'"> Cancel</button>
            </div>
        </form>
    </div>



</#macro>