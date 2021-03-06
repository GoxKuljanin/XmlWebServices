import { Component, OnInit } from '@angular/core';
import { KlasaVozila } from 'src/app/models/klasa-vozila';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-klasa-vozila',
  templateUrl: './klasa-vozila.component.html',
  styleUrls: ['./klasa-vozila.component.css']
})
export class KlasaVozilaComponent implements OnInit {
  
  constructor(private  klasaServis:AdminService,private router: Router) { }
  public klasaVozila:KlasaVozila=new KlasaVozila();
  ngOnInit() {
  }

  public onSubmit(): void{
    window.alert("Uspesno ste dodli novu klasu vozila");
    event.preventDefault();
    console.log("Usao u onsubmit klase vozila"+ this.klasaVozila.naziv );
    let res=this.klasaServis.saveKlasa(this.klasaVozila);
    console.log("poslato");
    this.router.navigateByUrl('/listaKlasaVozila');
    
  }
}
