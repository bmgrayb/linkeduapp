/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

            function readPicture(input, output)
            {
                if (input.files && input.files[0])
                {
                    var reader = new FileReader();
                    reader.onload = function(e)
                    {
                        output.attr('src', e.target.result);
                    };
                    reader.readAsDataURL(input.files[0]);
                }
            }

            $("[id='#{upload.clientId}']").change(
                function()
                {
                    readPicture(this, $("[id='#{image.clientId}']"));
                });