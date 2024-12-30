using Microsoft.AspNetCore.Mvc;

namespace AA_Backend.Controllers
{
    public class UsersController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
