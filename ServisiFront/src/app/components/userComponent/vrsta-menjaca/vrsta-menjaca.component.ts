import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { VrstaMenjaca } from 'src/app/models/vrsta-menjaca';
import {Router} from '@angular/router';
@Component({
  selector: 'app-vrsta-menjaca',
  templateUrl: './vrsta-menjaca.component.html',
  styleUrls: ['./vrsta-menjaca.component.css']
})
export class VrstaMenjacaComponent implements OnInit {

  options = {
    autoClose: false,
    keepAfterRouteChange: false
};


  constructor(private  vrstaMenjacaServis:AdminService,private router: Router) { }
  public vrstaMenjaca:VrstaMenjaca=new VrstaMenjaca();

  ngOnInit() {
  }


  public onSubmit(): void{
    window.alert("Uspesno ste dodali vrstu menjaca");
    event.preventDefault();
    console.log("Usao u onsubmit vrste menjaca"+ this.vrstaMenjaca.naziv );
    let res=this.vrstaMenjacaServis.saveMenjac(this.vrstaMenjaca);
    console.log("poslato");
    this.router.navigateByUrl('/listaVrstaMenjacaVozila');
    
  }


}
