package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new SpitterForm());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(
            @Valid SpitterForm spitterForm,
            Errors errors) throws IllegalStateException, IOException {

        if (errors.hasErrors()) {
            return "registerForm";
        }
        Spitter spitter = spitterForm.toSpitter();
        spitterRepository.save(spitter);
        MultipartFile profilePicture = spitterForm.getProfilePicture();
        if (!profilePicture.isEmpty()){
            System.out.printf("%s",profilePicture.getName());
            File picture = new File("F:\\Andersen\\TMP\\spittr\\" + spitter.getUsername() + ".jpg");
            picture.createNewFile();
            profilePicture.transferTo(picture);}
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(
            @PathVariable String username,
            Model model) {
        if (!model.containsAttribute("spitterForm")) {
            model.addAttribute(
                    spitterRepository.findByUsername(username));
        }
        return "profile";
    }
}