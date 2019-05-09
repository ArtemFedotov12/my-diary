<#include "security.ftl">
<#macro createClass>
    <div id="createClassId" class="modal">
        <form id="createClassFormId" class="modal-content animate" <#--action="/" method="post"-->>
            <div class="imgcontainer">
                <span onclick="document.getElementById('createClassId').style.display='none'" class="close" title="Close Modal">&times;</span>
                <img src="https://image.freepik.com/free-vector/modern-education-concept-with-flat-design_23-2147919753.jpg"
                     alt="Avatar" class="avatar">
            </div>

            <div class="container">

                <div class="valid-feedback" id="classCreateSuccessId" style="display: block; opacity: 0">
                    Class was created
                </div>

                <div>
                    <div class="invalid-feedback" id="classNumberLabelCreateClassId" style="display: none">
                        <#--Error Message-->
                    </div>
                    <label><b>Class Number</b></label>
                    <#-- name="username" because of @Override public String getUsername() { return login;}-->
                    <input type="number" id="classNumberCreateClassId" class="create-class form-control"  placeholder="6" name="classNumber" value="6" required>
                </div>

                <div>
                    <div class="invalid-feedback" id="classLetterLabelCreateClassId" style="display: none">
                        <#--Error Message-->
                    </div>
                    <label><b>Class Letter</b></label>
                    <input type="text" id="classLetterCreateClassId" class="create-class form-control" placeholder="A" name="classLetter" value="A" required>
                </div>

                <div>
                    <div class="invalid-feedback" id="accessKeyForSchoolKidLabelClassId" style="display: none">
                        <#--Error Message-->
                    </div>
                    <label><b>Access Key for School Kids</b></label>
                    <input type="text" id="accessKeyForSchoolKidClassId" class="create-class form-control" placeholder="robot" name="accessKeyForSchoolKid" value="robot" required>
                </div>

                <input  type="hidden" name="user" value="${currentUserId}">
                <input  type="hidden" name="_csrf" value="${_csrf.token}">
                <#--  <button type="submit" class="btn-login" onclick="createGradebook()">Create</button>-->
                <input type="button" class="btn-login" onclick="createClass()" value="Create">
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" id="cancelBtn"  class="cancelbtn fa fa-close"
                        onclick="document.getElementById('createClassId').style.display='none'"> Cancel</button>
            </div>

        </form>
    </div>

</#macro>