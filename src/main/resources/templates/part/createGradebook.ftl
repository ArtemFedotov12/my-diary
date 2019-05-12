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

                <div class="valid-feedback" id="gradeBookCreateSuccessId" style="display: block; opacity: 0">
                    Gradebook was created
                </div>


                <div>
                    <div class="invalid-feedback" id="classNumberLabelCreateGradeBookId" style="display: none">
                        <#--Error Message-->
                    </div>
                    <label><b>Class Number</b></label>
                    <div class="custom-select-new">
                        <select id="selectClassNumberCreateGradebookId" name="classNumber">

                        </select>
                    </div>
                </div>

                <div>
                    <div class="invalid-feedback" id="classLetterLabelCreateGradeBookId" style="display: none">
                        <#--Error Message-->
                    </div>
                    <label><b>Class Letter</b></label>
                    <div class="custom-select-new">
                        <select id="selectClassLetterCreateGradebookId" name="classLetter">

                        </select>
                    </div>
                </div>


                <div>
                    <div class="invalid-feedback" id="nameOfSubjectLabelCreateGradeBookId" style="display: none">
                        <#--Error Message-->
                    </div>
                    <label><b>Name of Subject</b></label>
                    <div class="custom-select-new">
                        <select id="selectSubjectsCreateGradebookId" name="nameOfSubject">

                        </select>
                    </div>
             <#--       <input type="text" id="nameOfSubjectCreateGradeBookId" class="create-class form-control" placeholder="Physics" name="nameOfSubject" value="Physics" required>-->
                </div>

                <input  type="hidden" name="user" value="${currentUserId}">
                <input  type="hidden" name="_csrf" value="${_csrf.token}">
                <#--  <button type="submit" class="btn-login" onclick="createGradebook()">Create</button>-->
                <input type="button" class="btn-login" onclick="createGradebook()" value="Create">
            </div>
            <div class="container" style="background-color:#f1f1f1">
                <button type="button" id="cancelBtn"  class="cancelbtn fa fa-close"
                        onclick="document.getElementById('createGradeBookId').style.display='none'">Cancel</button>
            </div>
        </form>
    </div>

</#macro>